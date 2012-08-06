Ext.define('js_bdki.grid.MasterPembelianGrid', {
    extend: 'Ext.grid.Panel', 
	alias : 'widget.js_bdki.grid.MasterPembelianGrid',
	id: 'js_bdki.grid.MasterPembelianGrid',
	title: 'List Pembelian Barang',
	
	initComponent: function(){
		this.store = new Ext.data.Store({
        	model: 'js_bdki.model.PembelianModel',
        	data: [
    	       {no: '1', tanggal: '5/06/2012',code_barang:'123456', nama:'Printer', cabang:'Kalibata', vendor:'Vendor Bersama', harga:'50000'},
    	       {no: '2', tanggal: '10/06/2012',code_barang:'3NS23', nama:'Lemari', cabang:'Pasar Minggu', vendor:'Vendor A', harga:'70000'},
				{no: '3', tanggal: '26/06/2012',code_barang:'35D13', nama:'Mobil 1', cabang:'Cipayung', vendor:'Vendor 12345', harga:'60000'},
				{no: '4', tanggal: '17/06/2012',code_barang:'3B1123', nama:'Kursi', cabang:'Kramat Jati', vendor:'Vendor99', harga:'100000'},
				{no: '5', tanggal: '01/07/2012',code_barang:'301123', nama:'Meja', cabang:'Senen', vendor:'Vendor Bersama', harga:'30000'},
				{no: '6', tanggal: '20/07/2012',code_barang:'SADSSA', nama:'Komputer', cabang:'Senen', vendor:'Vendor 12354', harga:'15000'},
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
			 dataIndex: 'harga',
                header: 'Harga (Rp)',
                sortable: true,
                width: 100
            }

        ];
		
		js_bdki.grid.MasterPembelianGrid.superclass.initComponent.call(this);
	}
});
