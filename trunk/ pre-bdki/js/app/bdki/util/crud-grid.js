Ext.onReady(function(){

	Ext.BLANK_IMAGE_URL = '/BDKI/extjs/resources/images/default/s.gif';
	
    var Player = Ext.data.Record.create([
	{name: 'id'},
    {
        name: 'name',
        type: 'string'
    }, {
        name: 'customName',
        type: 'string'
    }, {
        name: 'customNumber',
        type: 'integer'
    },{
        name: 'email',
        type: 'string'
    }, {
        name: 'address',
        type: 'string'
    },{
        name: 'nation',
        type: 'string'
    }
    ]);
    
    var proxy = new Ext.data.HttpProxy({
        api: {
            read : 'player/view.do',
            create : 'player/create.do',
            update: 'player/update.do',
            destroy: 'player/delete.do'
        }
    });
    
    var reader = new Ext.data.JsonReader({
        totalProperty: 'total',
        successProperty: 'success',
        idProperty: 'id',
        root: 'data',
        messageProperty: 'message'  // <-- New "messageProperty" meta-data
    }, 
    Player);

 // The new DataWriter component.
    var writer = new Ext.data.JsonWriter({
        encode: true,
        writeAllFields: true
    });
    
 // Typical Store collecting the Proxy, Reader and Writer together.
    var store = new Ext.data.Store({
        id: 'user',
        proxy: proxy,
        reader: reader,
        writer: writer,  // <-- plug a DataWriter into the store just as you
							// would a Reader
        autoSave: false // <-- false would delay executing create, update,
						// destroy requests until specifically told to do so
						// with some [save] buton.
    });

    // read the data from simple array
    store.load();
    
    Ext.data.DataProxy.addListener('exception', function(proxy, type, action, options, res) {
    	Ext.Msg.show({
    		title: 'ERROR',
    		msg: res.message,
    		icon: Ext.MessageBox.ERROR,
    		buttons: Ext.Msg.OK
    	});
    });

    
    var editor = new Ext.ux.grid.RowEditor({
        saveText: 'Update'
    });
    

    // create grid
    var grid = new Ext.grid.GridPanel({
        store: store,
        columns: [
            {header: "NAME",
             width: 180,
             sortable: true,
             dataIndex: 'name',
             editor: {
                xtype: 'textfield',
                allowBlank: false
            }},
            {header: "CUSTOM NAME #",
             width: 160,
             sortable: true,
             dataIndex: 'customName',
             editor: {
                 xtype: 'textfield',
                 allowBlank: false
            }},
            {header: "CUSTOM NUMBER",
             width: 70,
             sortable: true,
             dataIndex: 'customNumber',
             editor: {
                xtype: 'textfield',
                allowBlank: false
            }},
            {header: "EMAIL",
                width: 200,
                sortable: true,
                dataIndex: 'email',
                editor: {
                   xtype: 'textfield',
                   allowBlank: false
               }},
           {header: "ADDRESS",
               width: 250,
               sortable: true,
               dataIndex: 'address',
               editor: {
                  xtype: 'textfield',
                  allowBlank: false
              }},
          {header: "NATION",
              width: 170,
              sortable: true,
              dataIndex: 'nation',
              editor: {
                 xtype: 'textfield',
                 allowBlank: false
             }}
        ],
        viewConfig:{forcefit:true},
        plugins: [editor],
        title: 'ManUtd Player',
        height: 300,
        width:535,
		frame:true,
		tbar: [{
            iconCls: 'icon-user-add',
            text: 'Add Player',
            handler: function(){
                var e = new Player({
                    name: 'New Guy',
                    customName: '?????',
                    customNumber: 0,
                    email: 'new@something.com',
                    address: '????',
                    nation: '????'                    
                });
                editor.stopEditing();
                store.insert(0, e);
                grid.getView().refresh();
                grid.getSelectionModel().selectRow(0);
                editor.startEditing(0);
            }
        },{
            iconCls: 'icon-user-delete',
            text: 'Remove Player',
            handler: function(){
                editor.stopEditing();
                var s = grid.getSelectionModel().getSelections();
                for(var i = 0, r; r = s[i]; i++){
                    store.remove(r);
                }
            }
        },{
            iconCls: 'icon-user-save',
            text: 'Save All Modifications',
            handler: function(){
        	Ext.MessageBox.confirm('Confirmation', 'Are you sure to make save all modifications?', function(btn){
        		   if(btn === 'yes'){
        			   store.save();
        		   }
        		 });
                
            }
        }]
    });

    // render to DIV
    grid.render('crud-grid');
});