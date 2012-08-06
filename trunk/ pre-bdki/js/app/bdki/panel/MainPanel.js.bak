Ext.define('js_bdki.panel.MainPanel', {
	extend : 'Ext.panel.Panel',
	alias : 'widget.js_bdki.panel.MainPanel',
	frame : true,
	layout : 'border',

	initComponent : function() {
		this.items = [ {
			xtype : 'toolbar',
			region : 'north',
			height : 30,
			items : [ {
				text : 'System',
				menu : {
					xtype : 'menu',
					plain : true,
					items : [ 
						{
							text : 'Ganti Password',
							scope : this,
							handler : function(item){
								Ext.getCmp('centerpanel').displayScreen(item.screenType);
							},
							screenType : 'js_bdki.form.GantiPasswordForm'					
						}, 
						{
							text : 'Logout',
							handler : function(item){
								window.location.href = 'login.html';
							}
						} ]
					}
			}, {
				text : 'Master Data',
				menu : {
					xtype : 'menu',
					plain : true,
					items : [ {
						text : 'User',
						scope : this,
						handler : function(item){
							Ext.getCmp('centerpanel').displayScreen(item.screenType);
						},
						screenType : 'js_bdki.panel.UserManagementPanel'
					}, {
						text : 'Role',
						scope : this,
						handler : function(item){
							Ext.getCmp('centerpanel').displayScreen(item.screenType);
						},
						screenType : 'js_bdki.form.RoleForm'
					}, {
						text : 'Vendor',
						scope: this,
						handler : function(item){
							Ext.getCmp('centerpanel').displayScreen(item.screenType);
						},
						screenType : 'js_bdki.panel.MasterVendorPanel'

					} ]
				}
			},
			{
				text : 'Inventory',
				menu : {
					xtype : 'menu',
					plain : true,
					items : [ {
						text : 'Master Barang',
						scope : this,
						handler : function(item){
							Ext.getCmp('centerpanel').displayScreen(item.screenType);
						},
						screenType : 'js_bdki.panel.MasterBarangPanel'
					}]
				}
			},
				
			{
				text : 'Transaksi',
				menu : {
					xtype : 'menu',
					plain : true,
					items : [ 
						{
							text : 'Form Pemesanan Barang',
							scope : this,
							handler : function(item){
								Ext.getCmp('centerpanel').displayScreen(item.screenType);
							},
							//screenType : 'js_bdki.panel.FormPemesananPanel'
							screenType : 'js_bdki.form.FormPemesananBarang'
						},
						{
							text : 'Penyewaan',
							scope : this,
							handler : function(item){
								Ext.getCmp('centerpanel').displayScreen(item.screenType);
							},
							screenType : 'js_bdki.panel.MasterPenyewaanPanel'
						},
						{	
							text : 'Pembelian',
							scope : this,
							handler : function(item){
								Ext.getCmp('centerpanel').displayScreen(item.screenType);
							},
							screenType : 'js_bdki.panel.MasterPembelianPanel'
						}
					]
				}
			}, {
				text : 'Report',
				menu : {
					xtype : 'menu',
					plain : true,
					items : [
  					    {
						    text : 'Chart',
						    scope : this,
						    handler : function(item){
							    Ext.getCmp('centerpanel').displayScreen(item.screenType);
						    },
						    screenType : 'js_bdki.panel.ChartDemoPanel'
					    }
					]
				}
			} ]
		}, {
			xtype : 'panel',
			title : 'Information',
			collapsible : true,
			region : 'east',
			width : 300
		}, {
			xtype : 'toolbar',
			region : 'south',
			height : 20,
			items : [ {
				text : 'current user : user1',
				xtype : 'label'
			} ]
		}, {
			id : 'centerpanel',
			xtype : 'js_bdki.panel.CenterPanel',
			region : 'center'
		} ] ;

    	js_bdki.panel.MainPanel.superclass.initComponent.call(this);
    }


});

