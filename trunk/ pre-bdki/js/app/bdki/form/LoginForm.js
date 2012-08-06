Ext.define('js_bdki.form.LoginForm', {
	extend : 'Ext.form.FormPanel', 
	alias : 'widget.js_bdki.form.LoginForm',
	id: 'js_bdki.form.LoginForm',
	title: 'Login Form',
    width: 600,
    height: 300,
    padding: 10,
    labelWidth: 100,
    initComponent: function() {
        this.items = [
		{
			xtype:'box',
			anchor:'',
			fieldLabel:'Image',
			padding: '5,5,5,5',
			autoEl:{
				tag:'div', 
				children:[{
					tag:'img',
					qtip:'Bank DKI',
					src:'/BDKI/images/icon.jpg'
				}]
	        }
			},
            {
                xtype: 'textfield',
					padding: '5,5,5,5',
		        id: 'j_username',
				name: 'j_username',
		        fieldLabel: 'Username',
				value: ''
            },
            {
				xtype: 'textfield',
				name: 'j_password',
				inputType: 'password',
					padding: '5,5,5,5',
				fieldLabel: 'Password'
            },
			{
                xtype: 'button',				
				text: 'Login',         
					padding: '5,5,5,5',
				handler: function(){
					Ext.Ajax.request({
						url: '/BDKIServer/test/login.do',
						success: function (){alert('Value has been sent!');},
						failure: function (){alert('Failure of sending...');},
						headers: {
							'my-header': 'foo'
						},
						params: { foo: 'j_username.getValue()' }
				    });
	           }
            }
        ];        
        js_bdki.form.LoginForm.superclass.initComponent.call(this);
    }
	
    	//var form = Ext.getCmp('js_bdki.form.LoginForm');
    	
});
