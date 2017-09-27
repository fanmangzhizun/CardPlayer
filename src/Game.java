import java.util.*;

/**
 * Created by faithpercious on 2017/9/25.
 */
public class Game {
    //游戏第一步，先出现玩家
    Scanner scanner=new Scanner(System.in);
    List<Player> players=new ArrayList<Player>();//使用List存放玩家
    int sc;
    Card card=new Card();

    public void play() {
        //根据我的想法暂时可以自定义玩家
        System.out.println("---------请输入你想拥有的玩家个数最多26人-----------");
        while (true) {
            try {
                sc = scanner.nextInt();
                if (sc > 0 && sc < 27) {
                    break;
                } else {
                    System.out.println("玩家人数众多，请稍后再试");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("请输入数字人数，不要调皮");
                scanner.next();
                continue;
            }
        }

        int playerlength =sc;//人数确定，进行玩家初始化
        for (int i = 0; i < playerlength; i++) {
            Player player = new Player();
            System.out.println("--------请输入第" + (i + 1) + "玩家的id和姓名-------------");
          int Id;
            do {//判断id是否存在，存在则重新创建
                while (true){
                try {
                    System.out.println("--------请输入id--------");
                    Id = scanner.nextInt();
                       player.setId(Id);
                    if (players.contains(player))
                        System.out.println("该玩家id已被使用，请重新申请");
                break;
                   }
                catch (InputMismatchException e){
                    System.out.println("请使用数字id");
                    scanner.next();//这句代码加上后，不会无限死循环了，bug没了，不懂
                    continue;
                                                  }
                }
            } while (players.contains(player));

            System.out.println("--------请输入玩家姓名-------- ");
            String name = scanner.next();
            player.setName(name);
            players.add(player);
            System.out.println("玩家的姓名和id是：" + player.getName() + "\t" + player.getId());
        }

                    //接下来便是洗牌和发牌操作
                    System.out.println("--------扑克牌出现了，大家把袖子撸起来--------");
                    card.testinit();
                    System.out.println("--------现在开始绝对公平的洗牌--------");
                    System.out.println("--------洗牌结束，开始发牌--------");

        for (int i=0;i<2;i++) {//玩家拿到手牌的操作
            for (int j = 0; j < playerlength; j++) {
                System.out.println("----玩家:" + players.get(j).getName() + "拿牌----");
                List<String> hlist = new ArrayList<String>();
                if (i==0) {
                    hlist.add(card.getWcardList().get(j).toString());//hist接受手牌用于传给player
                    players.get(j).setHandcardlist(hlist);
                }
                else {
                    hlist= players.get(j).getHandcardlist();
                hlist.add(card.getWcardList().get(j + playerlength).toString());
                    players.get(j).setHandcardlist(hlist);
                }
            }
        }

                System.out.println("--------发牌结束，开始游戏--------");
                    //进入游戏阶段
        //选出玩家自己手里最大的牌
        for (int sb=0;sb<playerlength;sb++){
            Collections.sort(players.get(sb).getHandcardlist(),new CardRules());
            System.out.println("玩家："+players.get(sb).getName()+"最大手牌为"+ players.get(sb).getHandcardlist().get(1));
        }

        //选出最大牌的玩家
        List<String> winnercard=new ArrayList<>();
        for (int winnercardmaker=0;winnercardmaker<playerlength;winnercardmaker++){
        winnercard.add(players.get(winnercardmaker).getHandcardlist().get(1).toString());
        }

        Collections.sort(winnercard,new CardRules());
        for (int winnermaker=0;winnermaker<playerlength;winnermaker++){
        if (winnercard.get(playerlength-1).equals(players.get(winnermaker).getHandcardlist().get(1)))
                {
                 System.out.println("玩家"+players.get(winnermaker).getName()+"取得胜利\t"+"id为:"+players.get(winnermaker).getId()+"\n请上台领奖");
                    break;
                }
         }
        System.out.println("--------看一下玩家各自的手牌--------");
        for (int k=0; k<playerlength;k++)
        {
            System.out.println("玩家"+players.get(k).getName()+"的手牌为"+players.get(k).getHandcardlist().toString());
        }
                    }
}
