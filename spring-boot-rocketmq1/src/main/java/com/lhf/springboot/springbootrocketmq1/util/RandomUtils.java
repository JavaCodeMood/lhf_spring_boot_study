package com.lhf.springboot.springbootrocketmq1.util;

import java.util.Random;

/**
 * @ClassName: RandomUtils
 * @Desc: 生成随机字符串
 * @Author: liuhefei
 * @Date: 2019/2/28 14:16
 */
public class RandomUtils {
    public static String getRandomString(int length){
        //1.  定义一个字符串（A-Z，a-z，0-9）即62个数字字母；
        //String str="zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
        String str="用我三生烟火，换你一世迷离。长街长，烟花繁，你挑灯回看，短亭短，红尘辗，我把萧再叹。终是谁使弦断，花落肩头，恍惚迷离多少红颜悴，多少相思碎，唯留血染墨香哭乱冢。苍茫大地一剑尽挽破，何处繁华笙歌落。斜倚云端千壶掩寂寞，纵使他人空笑我。任他凡事清浊，为你一笑间轮回甘堕。寄君一曲，不问曲终人聚散。谁将烟焚散，散了纵横的牵绊。听弦断，断那三千痴缠。坠花湮，湮没一朝风涟。花若怜，落在谁的指尖。灯火星星，人声杳杳，歌不尽乱世烽火。如花美眷，似水流年，回得了过去，回不了当初。似此星辰非昨夜，为谁风露立中宵。蝴蝶很美，终究蝴蝶飞不过沧海。山河拱手，为君一笑 。待浮花浪蕊俱尽，伴君幽独。";

        //2.  由Random生成随机数
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        //3.  长度为几就循环几次
        for(int i=0; i<length; ++i){
            //从62个的数字或字母中选择
            int number=random.nextInt(62);
            //将产生的数字通过length次承载到sb中
            sb.append(str.charAt(number));
        }
        //将承载的字符转换成字符串
        return sb.toString();
    }

    public static String getRandomString(){
        String[] strArr= {"乾坤有序，宇宙无疆，星辰密布，斗柄指航。",
                "昼白夜黑，日明月亮，风驰雪舞，电闪雷响。",
                "云腾致雨，露结晨霜，虹霓霞辉，雾沉雹降。",
                "春生夏长，秋收冬藏，时令应候，寒来暑往。",
                "远古洪荒，海田沧桑，陆地漂移，板块碰撞。",
                "山岳巍峨，湖泊荡漾，植被旷野，岛撒汪洋。",
                "冰川冻土，沙漠沃壤，木丰树森，岩多滩广。",
                "鸟飞兽走，鳞潜羽翔，境态和谐，物种安详。",
                "形分上下，道合阴阳，幽冥杳渺，天体著彰。",
                "凝气为精，聚能以场，缩浓而质，积微显量。",
                "化巨幻虚，恍惚成象，强固凌弱，柔亦制刚。",
                "终极必反，存兴趋亡，色空轮回，动静恒常。",
                "唯实众名，一理万方，父母爹娘，没齿难忘。",
                "兄弟姐妹，危困助帮，姑姨叔舅，亲戚互访。",
                "侄男闺少，哺育茁壮，夫妻相敬，梦忆糟糠。",
                "隔屋邻舍，遇事谦谅，伯公妪婆，慈孝赡养。",
                "尊朋礼友，仁义君郎，炎黄二帝，尧舜禅让。",
                "禹启世袭，灭桀商汤，周武伐纣，侯列各邦。",
                "秦皇集权，汉刘楚项，鼎立割据，乱晋八王。",
                "南北对峙，腐朽隋炀，贞观政要，五代续唐。",
                "陈桥兵变，耻辱靖康，耶律完颜，元建宋僵。",
                "钟离太祖，崇祯吊丧，清军入关，大臣驻藏。",
                "粉碎叛卓，犁域设将，台湾复归，守卫边防。",
                "鸦片战争，英占香港，戊戌维新，社会改良。",
                "辛亥革命，孙文思想，联盟抗倭，国共两党。",
                "定都京师，人民解放，诸子百家，孔孟老庄。",
                "扁鹊灵医，鲁班巧匠，罗盘硝药，针灸疗伤。",
                "蔡伦毕升，鉴真玄奘，易经论语，史记达畅。",
                "河图洛书，算术九章，西三红水，聊儒瓶厢。",
                "诗词曲赋，戏剧说唱，琵琶琴瑟，锣镲铿锵。",
                "笙箫呜咽，卧笛悠扬，筝音奔奋，唢呐高亢。",
                "荆浩匡庐，董源潇湘，米芾写意，悲鸿骏昂。",
                "笔墨纸砚，匾楣楹榜，楷隶篆刻，碑帖草狂。",
                "敦煌石窟，长城伟墙，青铜甲骨，缕衣纱裳。",
                "虎符越剑，陶马俑葬，彩瓷宝瓮，丝绸他乡。",
                "凡尔赛宫，金字塔状，泰姬陵墓，彼得教堂。",
                "自由女神，希腊塑像，最后晚餐，创造亚当。",
                "亭榭楼阁，寺庙殿廊，蓬门荜户，丈室绿窗。",
                "府弟别墅，画栋雕梁，庭院踏步，影屏幕障。",
                "承尘藻井，篱笆柱桩，舷舵扶靠，凭栏眺望。",
                "悬崖峭壁，峰峦叠嶂，泉喷岚罩，湍急瀑宕。",
                "峡沟潭渊，溪涧流淌，池渠堰坝，沼泽泥塘。",
                "漩涡带波，礁屿连江，汹涌澎湃，惊涛骇浪。",
                "灾涝溢泻，汛潮浮涨，苍松寿柏，垂柳毛杨。",
                "芭蕉蒲扇，斑竹篾筐，槐椿榆桦，杉桂榕樟。",
                "斋扉紧闭，栅苑濒旁，坪埔莱茵，菲窥坞坊。",
                "蔷薇翩跹，莆菏蔚茫，蕴蒂荚芯，蓓蕾琳琅。",
                "奇花异卉，艳丽荣秧，兰荷菊梅，四季芬芳。",
                "杜鹃泣血，芙蓉吉祥，茉莉馥郁，玫瑰刺芒。",
                "瓜果蔬菜，葱蒜韭姜，茴椒芹葵，皮芥辣酱。",
                "芸苔芋笋，葫芦瓢瓤，番茄蘑菇，乳蛋醇酿。",
                "碘盐食醋，脆卜甜糖，珍馐旨甘，肴馔膏粱。",
                "葡萄美酒，玉液琼浆，咖啡益智，茗茶顺肠。",
                "桃李杏柿，汁鲜味爽，椰柚橙桔，渴饮品尝。",
                "菠萝柑橘，橄榄槟榔，梨枣苹楂，荔栗榴棠。",
                "蝌蚪摆尾，蛤蟆鼓囊，钓饵蚯蚓，蠕虫蚂蟥。",
                "鹦鹉学舌，蜜蜂穿忙，蝙蝠栖洞，梧桐引凰。",
                "蜘蛛牵补，螟蛉蛀粮，蜻蜓振翅，鸠鹏张膀。",
                "鸥莺燕雀，蝴蝶鸳鸯，鲤鲫鲇鲸，蛙蚌螺螃。",
                "蚜蛾蝉蛹，龟卵翼蝗，蚊蝇鼠蚁，蛇蝎鳝蟒。",
                "蜈蚣毒腺，蟋蟀蹬闯，鹿狈狐狸，熊豹豺狼。",
                "猿啼猴吱，鸵孵獭躺，雏猩攀梢，雌牡匿冈。",
                "砂舟骆驼，迅捷羚羊。"};
        String str = strArr[(int)(Math.random()*62)];
        return str;
    }

    public static String getRandomNum(int length){
        //1.  定义一个字符串（A-Z，a-z，0-9）即62个数字字母；
        String str="1234567890";
        //2.  由Random生成随机数
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        //3.  长度为几就循环几次
        for(int i=0; i<length; ++i){
            //从10个的数字中选择
            int number=random.nextInt(10);
            //将产生的数字通过length次承载到sb中
            sb.append(str.charAt(number));
        }
        //将承载的字符转换成字符串
        return sb.toString();
    }


    public static void main(String[] args) {
        //这里的32是生成32位随机码，根据你的需求，自定义
        String random1 = getRandomString(32);
        System.out.println(random1);
        String random2 = getRandomNum(32);
        System.out.println(random2);
    }

}
