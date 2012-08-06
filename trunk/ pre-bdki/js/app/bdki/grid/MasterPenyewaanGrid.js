Ext.define('js_bdki.grid.MasterPenyewaanGrid', {
    extend: 'Ext.grid.Panel', 
	alias : 'widget.js_bdki.grid.MasterPenyewaanGrid',
	id: 'js_bdki.grid.MasterPenyewaanGrid',
	title: 'List Penyewaan Barang',
	
	initComponent: function(){
		this.store = new Ext.data.Store({
        	model: 'js_bdki.model.PenyewaanModel',
        	data: [
    	       {no: '1', tanggal: '15/06/2012',code_barang:'321123', nama:'Lemari', cabang:'Kramat Jati', vendor:'Vendor Bersama',tgl_selesai: '15/06/2013'},
    	       {no: '2', tanggal: '15/06/2012',code_barang:'3NS23', nama:'Printer', cabang:'Pasar Minggu', vendor:'Vendor A',tgl_selesai: '15/06/2014'},
				{no: '3', tanggal: '16/06/2012',code_barang:'356113', nama:'Mobil', cabang:'Manggarai', vendor:'Vendor 12345',tgl_selesai: '16/06/2013'},
				{no: '4', tanggal: '17/06/2012',code_barang:'3B1123', nama:'Kursi', cabang:'Kramat Jati', vendor:'Vendor99',tgl_selesai: '17/06/2013'},
				{no: '5', tanggal: '20/06/2012',code_barang:'301123', nama:'Komputer', cabang:'Senen', vendor:'Vendor Bersama',tgl_selesai: '20/09/2012'},
				{no: '6', tanggal: '01/07/2012',code_barang:'32IJD3', nama:'Meja', cabang:'Pasar Baru', vendor:'Vendor 12354',tgl_selesai: '01/07/2013'},
        	]
        });
        
		this.columns = [
            {
                dataIndex: 'no',
                header: 'No',
                sortable: true,
                width: 50
            },
            {
                dataIndex: 'tanggal',
                header: 'Tanggal',
                sortable: true,
                width: 100
            },
			{             
			    dataIndex: 'code_barang',
                header: 'Kode Barang',
                sortable: true,
                width: 100
            },
			{             
				dataIndex: 'nama',
                header: 'Nama',
                sortable: true,
                width: 150
            },
			{             
			    dataIndex: 'cabang',
                header: 'Cabang',
                sortable: true,
                width: 200
            },
			{             
			 dataIndex: 'vendor',
                header: 'Vendor',
                sortable: true,
                width: 150
            },
			 {             
				dataIndex: 'tgl_selesai',
                header: 'Tgl Selesai',
                sortable: true,
                width: 150
            }

        ];
		
		js_bdki.grid.MasterPenyewaanGrid.superclass.initComponent.call(this);
	}
});
