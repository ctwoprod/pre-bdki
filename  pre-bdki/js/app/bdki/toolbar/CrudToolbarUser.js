Ext.define('js_bdki.toolbar.CrudToolbarUser', {
	extend : 'Ext.toolbar.Toolbar', 
	alias : 'widget.js_bdki.toolbar.CrudToolbarUser',
    initComponent: function() {
        this.items = [
            {
                xtype: 'button',
                text: 'Add', 
                scope: this, 
                handler: function(){
                    this.fireEvent('onCrudToolbarAdd', this);
                }
            },
            {
                xtype: 'button',
                text: 'Edit', 
                scope: this, 
                handler: function(){
                    this.fireEvent('onCrudToolbarEdit', this);
                }
            },
            {
                xtype: 'button',
                text: 'Delete', 
                scope: this, 
                handler: function(){
                    this.fireEvent('onCrudToolbarDelete', this);
                }
            },
            {
                xtype: 'button',
                text: 'Save', 
                scope: this, 
                handler: function(){
                    this.fireEvent('onCrudToolbarSave', this);
                }
            },
            {
                xtype: 'button',
                text: 'Cancel', 
                scope: this, 
                handler: function(){
                    this.fireEvent('onCrudToolbarCancel', this);
                }
            },
			{
                xtype: 'button',
                text: 'PDF', 
                scope: this, 
                handler: function(){
					Ext.Ajax.request({
						isUpload:true,
						url: '/BDKIServer/PrintServlet',						
						headers: {
							'my-header': 'valueMyHeader'
						},
						params: { reportType: 'rptUser' }
					});
                }
            }
        ];
        
        js_bdki.toolbar.CrudToolbarUser.superclass.initComponent.call(this);
    }
});

