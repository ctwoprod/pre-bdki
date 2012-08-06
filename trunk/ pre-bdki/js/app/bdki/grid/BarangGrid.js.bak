Ext.define('js_bdki.grid.BarangGrid', {
    extend: 'Ext.grid.Panel', 
	alias : 'widget.js_bdki.grid.BarangGrid',
	id: 'js_bdki.grid.BarangGrid',
	title: 'List Barang',
	
	initComponent: function(){
		
		var remoteStore = Ext.create('Ext.data.JsonStore', {
            fields: [
                {name: 'code_barang'},
                {name: 'name'},
                {name: 'description'},
                {name: 'vendor'}
            ],
            proxy: {
                type: 'ajax',
                url: '/BDKIServer/inventory/getBarang.do',
                reader: {
                    type: 'json',
                    root: 'listBarang'
                }
            }
        });

		this.store = remoteStore;

		remoteStore.load();
        
		this.columns = [
            {
                dataIndex: 'code_barang',
                header: 'Kode Barang',
                sortable: true,
                width: 100
            },
            {
                dataIndex: 'name',
                header: 'Nama',
                sortable: true,
                width: 300
            },
			{
                dataIndex: 'description',
                header: 'Deskripsi',
                sortable: true,
                width: 300
            },
			{
                dataIndex: 'vendor',
                header: 'Vendor',
                sortable: true,
                width: 300
            }
        ];
		
		js_bdki.grid.BarangGrid.superclass.initComponent.call(this);
	}
});
