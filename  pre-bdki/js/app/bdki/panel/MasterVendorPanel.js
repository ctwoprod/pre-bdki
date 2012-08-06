Ext.define('js_bdki.panel.MasterVendorPanel', {
	extend : 'Ext.panel.Panel', 
	alias : 'widget.js_bdki.panel.MasterVendorPanel',
	id: 'js_bdki.panel.MasterVendorPanel',
    title: 'Master Vendor',
    layout: 'border',
    initComponent: function() {
        this.items = [
            {
			   xtype: 'js_bdki.form.VendorForm',
				region: 'north',
				height: 200		        
			},
			{				
            xtype: 'js_bdki.grid.VendorGrid',
                region: 'center',
                listeners : {
	            	scope: this, 
	            	selectionChange: this.onVendorRowClick
				}
			}
        ];
        
        this.tbar = {
            xtype: 'js_bdki.toolbar.CrudToolbarVendor', 
            listeners: {
            	scope: this, 
            	onCrudToolbarAdd: this.newVendor,
            	onCrudToolbarEdit: this.editVendor, 
            	onCrudToolbarSave: this.saveVendor,
            	onCrudToolbarCancel: this.resetVendorForm,
				onCrudToolbarPDF: this.pdfVendor
            }
        };
        js_bdki.panel.MasterVendorPanel.superclass.initComponent.call(this);
    }, 
    
    newVendor: function(){
    	Ext.getCmp('js_bdki.form.VendorForm').getForm().reset();
    	Ext.getCmp('js_bdki.form.VendorForm').enableVendorForm();
    }, 
    
    editVendor: function(){
    	Ext.getCmp('js_bdki.form.VendorForm').enableVendorForm();
    }, 
    
    saveVendor: function(){
    	Ext.getCmp('js_bdki.form.VendorForm').simpanVendor();
    },
    
    resetVendorForm: function(){
    	Ext.getCmp('js_bdki.form.VendorForm').getForm().reset();
    	Ext.getCmp('js_bdki.form.VendorForm').disableVendorForm();
    }, 
    
	pdfVendor: function(){
    	
    }, 
    onVendorRowClick: function(model, records){
    	var selection = records[0];
    	if(selection){
    		Ext.getCmp('js_bdki.form.VendorForm').loadRecord(selection);
    	}
    }
});
