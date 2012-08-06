Ext.define('js_bdki.form.UserForm', {
	extend : 'Ext.form.FormPanel', 
	alias : 'widget.js_bdki.form.UserForm',
	id: 'js_bdki.form.UserForm',
	title: 'User Form',
    labelWidth: 200,
    bodyStyle:'padding:10px 10px 0',
    initComponent: function() {
        this.items = [
            {
                xtype: 'textfield',
                name: 'username',
                fieldLabel: 'Username',
                allowBlank:false
            },
            {
                xtype: 'textfield',
                name: 'email',
                fieldLabel: 'Email'
            },
            {
                xtype: 'textfield',
                fieldLabel: 'Password',
                inputType: 'password'
            },
            {
                xtype: 'textfield',
                fieldLabel: 'Confirm',
                inputType: 'password'
            }
        ];
        js_bdki.form.UserForm.superclass.initComponent.call(this);
        this.disableUserForm();
    },
    
    enableUserForm: function(){
    	this.getForm().getFields().each(function(f){
    		f.setReadOnly(false);
    	});
    }, 
    
    disableUserForm: function(){
    	this.getForm().getFields().each(function(f){
    		f.setReadOnly(true);
    	});
    }, 
    
    simpanUser: function(){
    	var form = Ext.getCmp('js_bdki.form.UserForm');
		//form.getForm().findField('username').getValue()
    	if(form.getForm().isValid()){
    		Ext.MessageBox.alert(
                'TODO','implement form save'
            );
			/*Ext.Ajax.request({
				url: '/BDKIServer/test/testPost.do',
				success: function (){alert('Value has been sent!');},
				failure: function (){alert('Failure of sending...');},
				headers: {
					'my-header': 'foo'
				},
				params: { param1: form.getForm().findField('username').getValue(), 
						  param2: form.getForm().findField('email').getValue(), 
						  param3: form.getForm().findField('email').getValue() + ' tambah'}
			});	*/
    	} else {
    		Ext.MessageBox.alert(
                'Error!',
                'Please check again'
            );	
    	}
    }
});
