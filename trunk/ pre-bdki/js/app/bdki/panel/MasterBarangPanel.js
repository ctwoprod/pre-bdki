Ext.define('js_bdki.panel.MasterBarangPanel', {
	extend : 'Ext.panel.Panel', 
	alias : 'widget.js_bdki.panel.MasterBarangPanel',
	id: 'js_bdki.panel.MasterBarangPanel',
    title: 'Inventory Barang',
    layout: 'border',
    initComponent: function() {
        this.items = [
            {
			   xtype: 'js_bdki.form.BarangForm',
				region: 'north',
				height: 200		        
			},
			{				
             xtype: 'js_bdki.grid.BarangGrid',
                region: 'center',
                listeners : {
	            	scope: this, 
	            	selectionChange: this.onBarangRowClick
				}
			}
        ];
        
        this.tbar = {
            xtype: 'js_bdki.toolbar.CrudToolbarBarang', 
            listeners: {
            	scope: this, 
            	onCrudToolbarAdd: this.newBarang,
            	onCrudToolbarEdit: this.editBarang, 
            	onCrudToolbarSave: this.saveBarang,
            	onCrudToolbarCancel: this.resetBarangForm,
				onCrudToolbarPDF: this.pdfBarang
            }
        };
        js_bdki.panel.MasterBarangPanel.superclass.initComponent.call(this);
    }, 
    
    newBarang: function(){
    	Ext.getCmp('js_bdki.form.BarangForm').getForm().reset();
    	Ext.getCmp('js_bdki.form.BarangForm').enableBarangForm();
    }, 
    
    editBarang: function(){
    	Ext.getCmp('js_bdki.form.BarangForm').enableBarangForm();
    }, 
    
    saveBarang: function(){
    	Ext.getCmp('js_bdki.form.BarangForm').simpanBarang();
    },
    
    resetBarangForm: function(){
    	Ext.getCmp('js_bdki.form.BarangForm').getForm().reset();
    	Ext.getCmp('js_bdki.form.BarangForm').disableBarangForm();
    }, 
    
	pdfBarang: function(){
    	
    }, 
    onBarangRowClick: function(model, records){
    	var selection = records[0];
    	if(selection){
    		Ext.getCmp('js_bdki.form.BarangForm').loadRecord(selection);
    	}
    }
});
