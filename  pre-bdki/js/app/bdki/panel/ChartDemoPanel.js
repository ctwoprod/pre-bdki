Ext.define('js_bdki.panel.ChartDemoPanel', {
	extend : 'Ext.panel.Panel',
	alias : 'widget.js_bdki.panel.ChartDemoPanel',
	id: 'js_bdki.panel.ChartDemoPanel',
    title: 'Chart Demo',
    layout: 'border',
    initComponent: function() {
        var myData = [
            {no: '1', bulan: 'Jan', sewa: 10, beli: 40},
            {no: '2', bulan: 'Feb', sewa: 45, beli: 50},
            {no: '3', bulan: 'Mar', sewa: 20, beli: 60},
            {no: '4', bulan: 'Apr', sewa: 80, beli: 30},
            {no: '5', bulan: 'May', sewa: 55, beli: 80},
            {no: '6', bulan: 'Jun', sewa: 65, beli: 50}
        ];

        var localStore = Ext.create('Ext.data.JsonStore', {
            fields: [
                {name: 'no', type: 'int'},
                {name: 'bulan'},
                {name: 'sewa', type: 'int'},
                {name: 'beli', type: 'int'}
            ],
            data: myData
        });

        var remoteStore = Ext.create('Ext.data.JsonStore', {
            fields: [
                {name: 'no', type: 'int'},
                {name: 'bulan'},
                {name: 'sewa', type: 'int'},
                {name: 'beli', type: 'int'}
            ],
            proxy: {
                type: 'ajax',
                url: '/BDKIServer/test/buatChart.do',
                reader: {
                    type: 'json',
                    root: 'transaksi'
                }
            }
        });

        remoteStore.load();

        this.items = [
            {
                region: 'center',
                xtype: 'grid',
                store: remoteStore,
                columns: [
                    {
                        text: '#',
							width:50,
                        dataIndex: 'no'
                    },
                    {
                        text: 'Bulan',
							width:50,
                        dataIndex: 'bulan'
                    },
                    {
                        text: 'Jumlah Request Sewa Barang',
							width:200,
                        dataIndex: 'sewa'
                    },
                    {
                        text: 'Jumlah Pembelian Barang',
							width:200,
                        dataIndex: 'beli'
                    }
                ]
            },
            {
                region: 'south',
                height: '50%',
                layout: 'border',
                items : [
                    {
                        region: 'east',
                        width: '50%',
                        xtype: 'chart',
                        animate: 'true',
                        shadow: 'true',
                        store: remoteStore,
                        legend: {position: 'right'},
                        series: [
                            {
                                type: 'pie',
                                field: 'sewa',
                                showInLegend: true,
                                label: {
                                    field: 'bulan',
                                    display: 'rotate',
                                    contrast: true
                                },
                                tips: {
                                  trackMouse: true,
                                  width: 140,
                                  height: 28,
                                  renderer: function(storeItem, item) {
                                        //calculate percentage.
                                        var total = 0;
                                        remoteStore.each(function(rec) {
                                            total += rec.get('sewa');
                                        });
                                        this.setTitle(storeItem.get('bulan') + ': ' + storeItem.get('sewa') + ' unit - ' + Math.round(storeItem.get('sewa') / total * 100) + '%');
                                  }
                                },
                                highlight: {
                                  segment: {
                                    margin: 20
                                  }
                                }
                            }
                        ]
                    },
                    {
                        xtype: 'chart',
                        region: 'center',
                        style: 'background:#fff',
                        animate: true,
                        store: remoteStore,
                        shadow: true,
                        legend: {
                            position: 'right'
                        },
                        axes: [
                            {
                                type: 'Numeric',
                                minimum: 0,
                                position: 'left',
                                fields: ['beli', 'sewa'],
                                title: 'Jumlah Transaksi Barang',
                                minorTickSteps: 1
                            }, {
                                type: 'Category',
                                position: 'bottom',
                                fields: ['bulan'],
                                title: 'Bulan'
                            }
                        ],
                        series: [
                              {
                                type: 'line',
                                highlight: {
                                    size: 7,
                                    radius: 7
                                },
                                axis: 'left',
                                xField: 'bulan',
                                yField: 'beli'
                            },
                            {
                                type: 'column',
                                highlight: {
                                    size: 7,
                                    radius: 7
                                },
                                axis: 'left',
                                xField: 'bulan',
                                yField: 'sewa'
                            }
                        ]
                    }
                ]
            }
        ];



        js_bdki.panel.ChartDemoPanel.superclass.initComponent.call(this);
    }
});

