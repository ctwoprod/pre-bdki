Ext.define('js_bdki.panel.MasterPembelianPanel', {
	extend : 'Ext.panel.Panel', 
	alias : 'widget.js_bdki.panel.MasterPembelianPanel',
	id: 'js_bdki.panel.MasterPembelianPanel',
    title: 'Master Pembelian',
    layout: 'border',
    initComponent: function() {
        this.items = [
            {
                xtype: 'js_bdki.grid.MasterPembelianGrid',
                region: 'center'
            }
        ];
        js_bdki.panel.MasterPembelianPanel.superclass.initComponent.call(this);
    }
});
