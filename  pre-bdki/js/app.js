// Register namespaces and their corresponding paths to Ext.Loader
Ext.Loader.setPath({
    'js_bdki': 'js/app/bdki'
});

// Specify a list of classes your application your application needs
Ext.require([
    'Ext.container.Viewport',
    'Ext.layout.container.Border',
    'Ext.chart.Chart',
    'Ext.menu.Menu',
    'Ext.form.Label',
    'js_bdki.toolbar.CrudToolbarBarang',
	'js_bdki.toolbar.CrudToolbarVendor',
	'js_bdki.toolbar.CrudToolbarUser',
    'js_bdki.grid.UserGrid',
	'js_bdki.grid.MasterPenyewaanGrid',
	'js_bdki.grid.MasterPembelianGrid',
    'js_bdki.model.UserModel',
	'js_bdki.model.PenyewaanModel',
	'js_bdki.model.PembelianModel',
    'js_bdki.form.RoleForm',
    'js_bdki.form.GantiPasswordForm',
    'js_bdki.form.UserForm',
	'js_bdki.form.FormPemesananBarang',
    'js_bdki.panel.UserManagementPanel',
	'js_bdki.panel.MasterPenyewaanPanel',
	'js_bdki.panel.MasterPembelianPanel',
    'js_bdki.panel.ChartDemoPanel',
    'js_bdki.panel.CenterPanel',
    'js_bdki.panel.MainPanel',
    'js_bdki.grid.BarangGrid',
	'js_bdki.grid.VendorGrid',
    'js_bdki.form.BarangForm',
	'js_bdki.form.VendorForm',
    'js_bdki.panel.MasterBarangPanel',
    'js_bdki.panel.MasterVendorPanel',
	'js_bdki.panel.FormPemesananPanel'
]);
Ext.Loader.setConfig({		
	enabled: true
});

Ext.require('Ext.chart.*');

// Application's initialization
Ext.onReady(function() {
	var myMask = new Ext.LoadMask(Ext.getBody(), {msg:"Please wait..."});
	myMask.show();
    var win = Ext.create('Ext.container.Viewport', {
        id: 'mainScreen',
        layout: 'fit',
        plain: true,
        closable: false,        
        items: [
            {
            	xtype : 'js_bdki.panel.MainPanel'
            }
        ]
    });
    var task = new Ext.util.DelayedTask(function(){myMask.destroy();});      
    task.delay(1000); //di hilangkan setelah 1 detik spertinya ini salah deh...
    win.show();
});