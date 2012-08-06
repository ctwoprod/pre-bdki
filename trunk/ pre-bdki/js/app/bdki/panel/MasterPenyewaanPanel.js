Ext.define('js_bdki.panel.MasterPenyewaanPanel', {
	extend : 'Ext.panel.Panel', 
	alias : 'widget.js_bdki.panel.MasterPenyewaanPanel',
	id: 'js_bdki.panel.MasterPenyewaanPanel',
    title: 'Master Penyewaan',
    layout: 'border',
    initComponent: function() {
        this.items = [
            {
                xtype: 'js_bdki.grid.MasterPenyewaanGrid',
                region: 'center'
            }
        ];
        js_bdki.panel.MasterPenyewaanPanel.superclass.initComponent.call(this);
    }
});
