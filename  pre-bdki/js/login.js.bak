// Register namespaces and their corresponding paths to Ext.Loader
Ext.Loader.setPath({
    'js_bdki': 'js/app/bdki'
});

// Specify a list of classes your application your application needs
Ext.require([
    'Ext.container.Viewport',
    'js_bdki.panel.LoginPanel'
]);

// Application's initialization
Ext.onReady(function() {
	var myMask = new Ext.LoadMask(Ext.getBody(), {msg:"Please wait..."});
	myMask.show();
    var win = Ext.create('Ext.Window', {
        id: 'loginScreen',
        layout: 'fit',
        plain: true,
        closable: false,
        items: [
            {xtype : 'js_bdki.panel.LoginPanel'}
        ]
    });
    var task = new Ext.util.DelayedTask(function(){myMask.destroy();});      
    task.delay(1000); //di hilangkan setelah 1 detik spertinya ini salah deh...
    win.show();
});

