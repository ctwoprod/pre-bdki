Ext.define('js_bdki.grid.VendorGrid', {
    extend: 'Ext.grid.Panel', 
	alias : 'widget.js_bdki.grid.VendorGrid',
	id: 'js_bdki.grid.VendorGrid',
	title: 'List Vendor',
	
	initComponent: function(){
		
		var remoteStore = Ext.create('Ext.data.JsonStore', {
            fields: [
                {name: 'name'},
                {name: 'alamat'},
                {name: 'noTelp'}
            ],
            proxy: {
                type: 'ajax',
                url: '/BDKIServer/vendor/getVendor.do',
                reader: {
                    type: 'json',
                    root: 'listVendor'
                }
            }
        });

		this.store = remoteStore;

		remoteStore.load();
        
		this.columns = [
            {
                dataIndex: 'name',
                header: 'Nama',
                sortable: true,
                width: 300
            },
			{
                dataIndex: 'alamat',
                header: 'Alamat',
                sortable: true,
                width: 400
            },
			{
                dataIndex: 'noTelp',
                header: 'No Telp',
                sortable: true,
                width: 300
            }
        ];
		
		js_bdki.grid.VendorGrid.superclass.initComponent.call(this);
	}
});
