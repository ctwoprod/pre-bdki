Ext.define('js_bdki.form.BarangForm', {
	extend : 'Ext.form.FormPanel', 
	alias : 'widget.js_bdki.form.BarangForm',
	id: 'js_bdki.form.BarangForm',
	title: 'Form Barang',
    labelWidth: 200,
    bodyStyle:'padding:10px 10px 0',
    initComponent: function() {
        this.items = [
            {
                xtype: 'textfield',
                name: 'code_barang',
                fieldLabel: 'Kode Barang',
                allowBlank:false
            },
            {
                xtype: 'textfield',
                name: 'name',
                fieldLabel: 'Nama'
            },
            {
                xtype: 'textfield',
                name: 'description',
                fieldLabel: 'Deskripsi'
            },
            {
				xtype: 'textfield',
                name: 'vendor',
                fieldLabel: 'Vendor'
            }
        ];
        js_bdki.form.BarangForm.superclass.initComponent.call(this);
        this.disableBarangForm();
    },
    
    enableBarangForm: function(){
    	this.getForm().getFields().each(function(f){
    		f.setReadOnly(false);
    	});
    }, 
    
    disableBarangForm: function(){
    	this.getForm().getFields().each(function(f){
    		f.setReadOnly(true);
    	});
    }, 
    
    simpanBarang: function(){
    	var form = Ext.getCmp('js_bdki.form.BarangForm');
    	if(form.getForm().isValid()){
    		Ext.MessageBox.alert(
                'TODO','implement form save'
            );
    	} else {
    		Ext.MessageBox.alert(
                'Error!',
                'Please check again'
            );	
    	}
    }
});
