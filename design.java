import java.awt.*;
import java.io.*;
public class design extends java.applet.Applet
{
    //Start Screen
    Button signup=new Button("New User");
    Button exist=new Button("Existing User");
    //Signup or Login
    TextField username=new TextField();
    TextField password=new TextField();
    Button ok=new Button("GO");
    TextField user_name=new TextField();
    TextField pass_word=new TextField();
    Button o_k=new Button("OK");
    //Signup Screen
    TextField amt_bank=new TextField();
    TextField amt_wallet=new TextField();
    Button o__k=new Button("SUBMIT");
    //User Screen
    Button chk_blnc=new Button("Check Balance");
    Button trns_mon=new Button("Transfer Money");
    Button cal_bal=new Button("Calculate Balance");
    TextArea details=new TextArea();
    Choice logout=new Choice();

    Font heading=new Font("comic sans ms",Font.PLAIN,38);
    Font other=new Font("times new roman",Font.PLAIN,18);

    Image background;
    String broadcast="start";
    public void paint(Graphics g)
    {
        background=getImage(getCodeBase(),"images.jpg");
        g.drawImage(background,0,0,700,400,this);
        resize(700,400);
        g.setColor(Color.white);
        g.setFont(heading);
        g.drawString("ADMINISTRADOR de DINERS",90,50);

        if(broadcast.equals("exist"))
        {
            g.setFont(other);
            g.drawString("LOGIN",500,100);
            g.drawString("USER NAME",370,140);
            g.drawString(" PASSWORD",370,170);
        }
        if(broadcast.equals("signup"))
        {
            g.setFont(other);
            g.drawString("SIGNUP ",500,100);
            g.drawString("USER NAME",370,140);
            g.drawString(" PASSWORD",370,170);
        }
        if(broadcast.equals("signin"))
        {
            g.setFont(other);
            g.setColor(Color.white);
            g.drawString("  Money in Bank",350,140);
            g.drawString("Money in Wallet",350,170);
            g.drawString("WELCOME USER",550,80);
            g.drawString("User please enter",10,140);
            g.drawString("the details and",10,160);
            g.drawString("press the submit",10,180);
            g.drawString("button to complete",10,200);
            g.drawString("making your account.",10,220);
        }
        if(broadcast.equals("logged_in"))
        {
            g.setFont(other);
            g.setColor(Color.white);
            g.drawString("WELCOME USER",550,80);
        }
    }

    public void init()
    {
        setLayout(null);
        add(signup);
        signup.setSize(100,25);
        signup.setLocation(20,120);
        signup.hide();
        add(exist);
        exist.setSize(100,25);
        exist.setLocation(20,150);
        exist.hide();

        add(username);
        username.setSize(150,25);
        username.setLocation(500,120);
        username.hide();
        add(password);
        password.setEchoCharacter('*');
        password.setSize(150,25);
        password.setLocation(500,150);
        password.hide();
        add(ok);
        ok.setSize(60,25);
        ok.setLocation(500,180);
        ok.hide();

        add(user_name);
        user_name.setSize(150,25);
        user_name.setLocation(500,120);
        user_name.hide();
        add(pass_word);
        pass_word.setEchoCharacter('*');
        pass_word.setSize(150,25);
        pass_word.setLocation(500,150);
        pass_word.hide();
        add(o_k);
        o_k.setSize(60,25);
        o_k.setLocation(500,180);
        o_k.hide();

        add(amt_bank);
        amt_bank.setSize(150,25);
        amt_bank.setLocation(500,120);
        amt_bank.hide();
        add(amt_wallet);
        amt_wallet.setSize(150,25);
        amt_wallet.setLocation(500,150);
        amt_wallet.hide();
        add(o__k);
        o__k.setSize(60,25);
        o__k.setLocation(500,180);
        o__k.hide();

        add(chk_blnc);
        chk_blnc.setSize(120,25);
        chk_blnc.setLocation(10,140);
        chk_blnc.hide();
        add(trns_mon);
        trns_mon.setSize(120,25);
        trns_mon.setLocation(10,170);
        trns_mon.hide();
        add(cal_bal);
        cal_bal.setSize(120,25);
        cal_bal.setLocation(10,200);
        cal_bal.hide();
        add(details);
        details.setSize(530,270);
        details.setLocation(150,120);
        details.hide();
        add(logout);
        logout.setSize(70,25);
        logout.setLocation(570,90);
        if(broadcast.equals("start"))
        {
            logout.addItem("");
            logout.addItem("LOGOUT");
        }
        logout.hide();

        if(broadcast.equals("exist") || broadcast.equals("signup") || broadcast.equals("start"))
        {
            signup.show();
            exist.show();
        }
        if(broadcast.equals("exist"))
        {
            user_name.show();
            pass_word.show();
            o_k.show();
        }
        if(broadcast.equals("signup"))
        {
            username.show();
            password.show();
            ok.show();
        }
        if(broadcast.equals("signin"))
        {
            amt_bank.show();
            amt_wallet.show();
            o__k.show();
            logout.show();
        }
        if(broadcast.equals("logged_in"))
        {
            chk_blnc.show();
            trns_mon.show();
            cal_bal.show();
            details.show();
            logout.show();
        }
    }

    public boolean action(Event e, Object j)
    {
        if(e.target instanceof Button)
        {
            if(j.equals("Existing User"))
            {
                broadcast="exist";
                init();
                repaint();
            }
            if(j.equals("New User"))
            {
                broadcast="signup";
                init();
                repaint();
            }
            if(j.equals("GO"))
            {
                broadcast="signin";
                init();
                repaint();
            }
            if(j.equals("OK"))
            {
                broadcast="logged_in";
                init();
                repaint();
            }
        }
        if(e.target instanceof Choice)
        {
            if(j.equals("LOGOUT"))
            {
                broadcast="start";
                init();
                repaint();
            }
        }
        return true;
    }

    void write(String name,String pswd)
    {
        try{
            File f=new File(name+"_"+pswd+".txt");
            FileOutputStream f1= new FileOutputStream(f);

            if(!f.exists())
            {
                f.createNewFile();
            }

            f1.write(("CF CODE: ").getBytes());
            f1.flush();
            f1.close();
        }
        catch(IOException ie)
        {
        }
    }
}