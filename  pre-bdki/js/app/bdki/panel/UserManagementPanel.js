Ext.define('js_bdki.panel.UserManagementPanel', {
	extend : 'Ext.panel.Panel', 
	alias : 'widget.js_bdki.panel.UserManagementPanel',
	id: 'js_bdki.panel.UserManagementPanel',
    title: 'User Management',
    layout: 'border',
    initComponent: function() {
        this.items = [
            {
                xtype: 'js_bdki.grid.UserGrid',
                region: 'center',
                listeners : {
	            	scope: this, 
	            	selectionChange: this.onUserRowClick
	            }
            },
            {
                xtype: 'js_bdki.form.UserForm',
                region: 'north',
                height: 200
            }
        ];
        
        this.tbar = {
            xtype: 'js_bdki.toolbar.CrudToolbarUser', 
            listeners: {
            	scope: this, 
            	onCrudToolbarAdd: this.newUser,
            	onCrudToolbarEdit: this.editUser, 
            	onCrudToolbarSave: this.saveUser,
            	onCrudToolbarCancel: this.resetUserForm
            }
        };
        js_bdki.panel.UserManagementPanel.superclass.initComponent.call(this);
    }, 
    
    newUser: function(){
    	Ext.getCmp('js_bdki.form.UserForm').getForm().reset();
    	Ext.getCmp('js_bdki.form.UserForm').enableUserForm();
    }, 
    
    editUser: function(){
    	Ext.getCmp('js_bdki.form.UserForm').enableUserForm();
    }, 
    
    saveUser: function(){
    	Ext.getCmp('js_bdki.form.UserForm').simpanUser();
    },
    
    resetUserForm: function(){
    	Ext.getCmp('js_bdki.form.UserForm').getForm().reset();
    	Ext.getCmp('js_bdki.form.UserForm').disableUserForm();
    }, 
    
    onUserRowClick: function(model, records){
    	var selection = records[0];
    	if(selection){
    		Ext.getCmp('js_bdki.form.UserForm').loadRecord(selection);
    	}
    }
});
