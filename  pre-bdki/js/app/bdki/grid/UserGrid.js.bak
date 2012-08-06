Ext.define('js_bdki.grid.UserGrid', {
    extend: 'Ext.grid.Panel', 
	alias : 'widget.js_bdki.grid.UserGrid',
	id: 'js_bdki.grid.UserGrid',
	title: 'User List',
	
	initComponent: function(){
		this.store = new Ext.data.Store({
        	model: 'js_bdki.model.UserModel',
        	data: [
    	       {username: 'didik', email: 'didik@gmail.com'},
    	       {username: 'roberto', email: 'roberto@gmail.com'}
        	]
        });
        
		this.columns = [
            {
                dataIndex: 'username',
                header: 'Username',
                sortable: true,
                width: 100
            },
            {
                dataIndex: 'email',
                header: 'Email',
                sortable: true,
                width: 300
            }
        ];
		
		js_bdki.grid.UserGrid.superclass.initComponent.call(this);
	}
});
