Ext.define('js_bdki.form.GantiPasswordForm', {
	extend : 'Ext.form.FormPanel', 
	alias : 'widget.js_bdki.form.GantiPasswordForm',
	id: 'js_bdki.form.GantiPasswordForm',
	title: 'Form Ganti Password',
    width: 600,
    height: 250,
    padding: 10,
    labelWidth: 400,
    initComponent: function() {
        this.items = [
            {
                xtype: 'textfield',
                fieldLabel: 'Username',
				labelWidth: 200
            },
            {
                xtype: 'textfield',
                fieldLabel: 'Password',
				inputType: 'password',
				labelWidth: 200
            },
			{
                xtype: 'textfield',
                fieldLabel: 'Konfirmasi Password',
				inputType: 'password',
				labelWidth: 200
            },
			{
				xtype: 'button',
				text: 'SIMPAN'
			},
			{
				xtype: 'button',
				margin: '2,2,2,2',
				text: 'RESET'
			}
        ];
        js_bdki.form.GantiPasswordForm.superclass.initComponent.call(this);
    }
});
