Ext.define('js_bdki.form.FormPemesananBarang', {
	extend : 'Ext.form.FormPanel', 
	alias : 'widget.js_bdki.form.FormPemesananBarang',
	id: 'js_bdki.form.FormPemesananBarang',
	title: 'Form Pemesanan Barang',
    labelWidth: 200,
    bodyStyle:'padding:10px 10px 0',
    initComponent: function() {
        this.items = [
                        {
                            xtype: 'fieldset',
                            height: 89,
                            title: 'Informasi Pemesan',
                            items: [
                                {
                                    xtype: 'textfield',
                                    fieldLabel: 'Nama Pemesan',
									readOnly: true
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: 'Cabang',
									readOnly: true
                                }
                            ]
                        },
                        {
                            xtype: 'fieldset',
                            height: 157,
                            title: 'Informasi Barang',
                            items: [
                                {
                                    xtype: 'panel',
                                    border: 0,
                                    height: 28,
                                    layout: {
                                        type: 'column'
                                    },
                                    items: [
                                        {
                                            xtype: 'textfield',
                                            margin: '5,0,0,0',
                                            fieldLabel: 'Kode Barang',
											readOnly: false
                                        },
                                        {
                                            xtype: 'button',
                                            margin: '5,0,0,0',
                                            text: 'Cari'
                                        }
                                    ]
                                },
                                {
										id: 'txtname',
									name: 'txtname',
                                    xtype: 'textfield',
                                    margin: '5,0,0,0',
                                    fieldLabel: 'Nama',
									readOnly: false
                                },
                                {
									name: 'txtHargaSatuan',
                                    xtype: 'textfield',
                                    margin: '5,0,0,0',
                                    fieldLabel: 'Harga Satuan',
									readOnly: false
                                },
                                {
									name: 'txtJumlah',
                                    xtype: 'textfield',
                                    margin: '5,0,0,0',
                                    fieldLabel: 'Jumlah',
									readOnly: false
                                }
                            ]
                        },
                        {
                            xtype: 'button',
                            text: 'Kirim',
							handler: function(){
							   var form = Ext.getCmp('js_bdki.form.FormPemesananBarang');
							   //form.getForm().findField('txtHargaSatuan').setValue('sadlasjlsa');
								if(form.getForm().isValid()){
									Ext.Ajax.request({
											url: '/BDKIServer/test/testPost.do',
											success: function (){alert('Value has been sent!');},
											failure: function (){alert('Failure of sending...');},
											headers: {
												'my-header': 'foo'
											},
											params: { param1: form.getForm().findField('txtname').getValue(), 
													  param2: form.getForm().findField('txtHargaSatuan').getValue(), 
													  param3: form.getForm().findField('txtJumlah').getValue()}
									});	
								}
							}
                        }
                    ];
        js_bdki.form.FormPemesananBarang.superclass.initComponent.call(this);
        this.enableForm();
    },
    
    enableForm: function(){
    	this.getForm().getFields().each(function(f){
    		f.setReadOnly(false);
    	});
    }, 
    
    disableForm: function(){
    	this.getForm().getFields().each(function(f){
    		f.setReadOnly(true);
    	});
    }
});
	