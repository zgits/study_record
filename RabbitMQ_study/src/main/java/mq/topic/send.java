package mq.topic;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.tools.json.JSONUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class send {

    private static final String EXCHANGE_NAME = "topicExchangeName";

    public static final String QUEUE_NAME = "topicQueueName";

    public static final String ROUTE_KEY1 = "topickey.add";

    public static final String ROUTE_KEY2 = "topickey.delete";

    public static final String ROUTE_KEY3 = "topickey.update";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        connectionFactory.setVirtualHost("gov");
        connectionFactory.setHost("172.16.4.222");
        connectionFactory.setUsername("admin");
        connectionFactory.setPort(5672);
        connectionFactory.setPassword("m1onr7G1M49QJf2q");

        Connection connection = connectionFactory.newConnection();

        Channel channel = connection.createChannel();

        channel.exchangeDeclare("huizhiTest", BuiltinExchangeType.TOPIC, true);


//        String message1 = "add message";
//        String message2 = "delete message";
//        String message3 = "update message";



        // 站点新建
//        for (int i = 0; i < 200; i++) {
//            Map<String, Object> data = new HashMap<String, Object>();
//            Map<String, Object> datach = new HashMap<String, Object>();
//
//            datach.put("ISOTHERPLATPUSHABLE", "0");
//            datach.put("OPERTIME", "");
//            datach.put("CRTIME", "2020-11-05 14:08:31");
//            datach.put("MEDIATYPE", "1");
//            datach.put("TRUENAME", "慧智人员");
//            datach.put("AUTOCHECK", "0");
//            datach.put("STATUS", "0");
//            datach.put("SITEDESCPINYIN", "hzzd");
//            datach.put("DATAPATH", "datapath"+i);
//            datach.put("SCHEDULE", "0");
//            datach.put("CHNLOUTLINETEMP", "9380");
//            datach.put("ISDISTRIBUTABLE", "1");
//            datach.put("SITENAME", "慧智站点");
//            datach.put("OUTLINETEMPLATE", "9380");
//            datach.put("PUBLISHPRO", "1");
//            datach.put("ISOTHERPLATDISTRIBUTABLE", "0");
//            datach.put("SITEORDER", "365");
//            datach.put("SITEID", String.valueOf(i));
//            datach.put("SITETYPE", "4");
//            datach.put("DETAILTEMPLATE", "4389");
//            datach.put("SITEDESC", "慧智站点");
//            datach.put("PARENTID", "0");
//            datach.put("ISMOBILE", "0");
//            datach.put("ISPUSHTOAUDIT", "0");
//            datach.put("CRUSER", "慧智人员");
//            datach.put("WEBHTTP", "http://192.168.200.124/pub/datapath" + i);
//            datach.put("ISOPENSAMESOURCE", "0");
//            data.put("TYPE", "11");
//            data.put("DATA", datach);
//
//            String message = JSON.toJSONString(data);
//            channel.basicPublish("huizhiTest", "test.huizhi.site", null, message.getBytes());
//        }


//        // 站点修改
//        for (int i = 0; i < 200; i++) {
//            Map<String, Object> data = new HashMap<String, Object>();
//            Map<String, Object> datach = new HashMap<String, Object>();
//
//            datach.put("ISOTHERPLATPUSHABLE", "0");
//            datach.put("OPERTIME", "");
//            datach.put("CRTIME", "2020-11-05 14:08:31");
//            datach.put("MEDIATYPE", "1");
//            datach.put("TRUENAME", "慧智人员");
//            datach.put("AUTOCHECK", "0");
//            datach.put("STATUS", "0");
//            datach.put("SITEDESCPINYIN", "hzzd");
//            datach.put("DATAPATH", "datapath"+i);
//            datach.put("SCHEDULE", "0");
//            datach.put("CHNLOUTLINETEMP", "9380");
//            datach.put("ISDISTRIBUTABLE", "1");
//            datach.put("SITENAME", "慧智站点"+i);
//            datach.put("OUTLINETEMPLATE", "9380");
//            datach.put("PUBLISHPRO", "1");
//            datach.put("ISOTHERPLATDISTRIBUTABLE", "0");
//            datach.put("SITEORDER", "365");
//            datach.put("SITEID", String.valueOf(i));
//            datach.put("SITETYPE", "4");
//            datach.put("DETAILTEMPLATE", "4389");
//            datach.put("SITEDESC", "慧智站点"+i);
//            datach.put("PARENTID", "0");
//            datach.put("ISMOBILE", "0");
//            datach.put("ISPUSHTOAUDIT", "0");
//            datach.put("CRUSER", "慧智人员");
//            datach.put("WEBHTTP", "http://192.168.200.124/pub/datapath" + i);
//            datach.put("ISOPENSAMESOURCE", "0");
//            data.put("TYPE", "12");
//            data.put("DATA", datach);
//
//            String message = JSON.toJSONString(data);
//            channel.basicPublish("huizhiTest", "test.huizhi.site", null, message.getBytes());
//        }




        //新建栏目
        for (int i = 1; i < 4; i++) {

            Map<String, Object> data = new HashMap<String, Object>();
            Map<String, Object> datach = new HashMap<String, Object>();

            datach.put("ISOTHERPLATPUSHABLE", "0");
            datach.put("CHNLTYPE", "0");
            datach.put("OPERTIME", "0");
            datach.put("CRTIME", "2020-11-05 14:08:31");
            datach.put("INHERIT", "0");
            datach.put("CHANNELID", i);
            datach.put("TRUENAME", "慧智人员");
            datach.put("TOOLBAR", "");
            datach.put("LINKURL", "");
            datach.put("ISSUBSCRIBE", "");
            datach.put("CHNLDESCPINYIN", "hzlm");
            datach.put("STATUS", "0");
            datach.put("ROOTDOMAIN", "http://www.huizih.com/test");
            datach.put("CHNLDETAILTEMP", "9379");
            datach.put("CHNLPROP", "4");
            datach.put("ISCONTAINSCHILDREN", "0");
            datach.put("CHNLOUTLINETEMP", "9380");
            datach.put("ISDISTRIBUTABLE", "1");
            datach.put("CHNLDATAPATH", "huizhi" + i);
            datach.put("PUBLISHPRO", "1");
            datach.put("ADVTOOLBAR", "1");
            datach.put("ISARCHIVING", "0");
            datach.put("ISCHECKPUSHDOC", "0");
            datach.put("ISOTHERPLATDISTRIBUTABLE", "0");
            datach.put("CHNLDESC", " 惠智测试新建栏目" + i);
            datach.put("SITEID", 18);
            datach.put("USESYSORDERBY", 1);
            datach.put("LASTMODIFYTIME", "");
            datach.put("CHNLNAME", " 惠智测试新建栏目" + i);
            datach.put("ISOPENMANUALSYN", 0);
            datach.put("PARENTID", 0);
            datach.put("ISPUSHABLE", 1);
            datach.put("ISPUSHTOAUDIT", 1);
            datach.put("CHNLORDER", 1);
            datach.put("CRUSER", "慧智人员");
            datach.put("ISCLUSTER", 0);
            datach.put("ISOPENSAMESOURCE", 0);
            datach.put("FLUENCEXML", "");
            datach.put("CHANNELTYPE", "站点所属栏目");

            data.put("TYPE", "11");
            data.put("DATA", datach);

            String message = JSON.toJSONString(data);
            channel.basicPublish("huizhiTest", "test.huizhi.channel", null, message.getBytes());

        }



        //修改栏目
//        for (int i = 0; i < 200; i++) {
//
//            Map<String, Object> data = new HashMap<String, Object>();
//            Map<String, Object> datach = new HashMap<String, Object>();
//
//            datach.put("ISOTHERPLATPUSHABLE", "0");
//            datach.put("CHNLTYPE", "0");
//            datach.put("OPERTIME", "2020-11-13 14:03:26");
//            datach.put("CRTIME", "2020-11-05 14:08:31");
//            datach.put("INHERIT", "0");
//            datach.put("CHANNELID", i);
//            datach.put("TRUENAME", "慧智人员");
//            datach.put("TOOLBAR", "");
//            datach.put("LINKURL", "");
//            datach.put("ISSUBSCRIBE", "0");
//            datach.put("CHNLDESCPINYIN", "hzlm");
//            datach.put("STATUS", "0");
//            datach.put("ROOTDOMAIN", "http://www.huizih.com/test");
//            datach.put("CHNLDETAILTEMP", "1");
//            datach.put("CHNLPROP", "4");
//            datach.put("ISCONTAINSCHILDREN", "0");
//            datach.put("CHNLOUTLINETEMP", "9380");
//            datach.put("ISDISTRIBUTABLE", "1");
//            datach.put("CHNLDATAPATH", "huizhi");
//            datach.put("PUBLISHPRO", "1");
//            datach.put("ADVTOOLBAR", "1");
//            datach.put("ISARCHIVING", "0");
//            datach.put("ISCHECKPUSHDOC", "0");
//            datach.put("ISOTHERPLATDISTRIBUTABLE", "0");
//            datach.put("CHNLDESC", "慧智栏目" + i);
//            datach.put("SITEID", 18);
//            datach.put("USESYSORDERBY", 1);
//            datach.put("LASTMODIFYTIME", "");
//            datach.put("CHNLNAME", "慧智栏目" + i);
//            datach.put("ISOPENMANUALSYN", 0);
//            datach.put("PARENTID", 0);
//            datach.put("ISPUSHABLE", 1);
//            datach.put("ISPUSHTOAUDIT", 1);
//            datach.put("CHNLORDER", 1);
//            datach.put("CRUSER", "慧智人员");
//            datach.put("ISCLUSTER", 0);
//            datach.put("ISOPENSAMESOURCE", 0);
//            datach.put("FLUENCEXML", "");
//            datach.put("CHANNELTYPE", "站点所属栏目");
//            datach.put("OPERUSER", "慧智人员");
//
//            data.put("TYPE", "12");
//            data.put("DATA", datach);
//
//            String message = JSON.toJSONString(data);
//            channel.basicPublish("huizhiTest", "test.huizhi.channel", null, message.getBytes());
//
//        }


        System.out.println("消息发送成功");
//
//        channel.basicPublish(EXCHANGE_NAME,ROUTE_KEY1,null,message1.getBytes());
//
//        channel.basicPublish(EXCHANGE_NAME,ROUTE_KEY2,null,message2.getBytes());
//        channel.basicPublish(EXCHANGE_NAME,ROUTE_KEY3,null,message3.getBytes());
//        channel.basicPublish(EXCHANGE_NAME,"topickey.test.all",null,"test".getBytes());

        channel.close();
        connection.close();

    }
}
