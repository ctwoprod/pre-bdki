Ext.define('js_bdki.panel.FormPemesananPanel', {
	extend : 'Ext.panel.Panel', 
	alias : 'widget.js_bdki.panel.FormPemesananPanel',
	id: 'js_bdki.panel.FormPemesananPanel',
    title: 'Form Pemesanan Panel',
    layout: 'border',
    initComponent: function() {
        this.items = [
            {
                xtype: 'js_bdki.form.FormPemesananBarang',
                region: 'center'
            }
        ];
        js_bdki.panel.UserManagementPanel.superclass.initComponent.call(this);
    }
});
