class Player
{
    private String name;
    private double points;
    private int white;
    private int black;
    private int games;
    private int timesUnopposed;
    private String color;
    
    public Player()
    {
    	name = "";
        points = 0;
        white = 0;
        black = 0;
        games = 0;
        color = "";
        timesUnopposed = 0;
    }
    
    public Player(String n)
    {
    	name = n;
        points = 0;
        white = 0;
        black = 0;
        games = 0;
        color = "";
        timesUnopposed = 0;
    }
    
    public String getName()
    {return name;}
    
    public void setName(String x)
    {this.name = x;}
    
    public double getPoints()
    {return points;}
    
    public void setPoints(double x)
    {this.points = x;}
    
    public int getWhite()
    {return white;}
    
    public void setWhite(int x)
    {this.white = x;}
    
    public int getBlack()
    {return black;}
    
    public void setBlack(int x)
    {this.black = x;}
    
    public void addWhite(int x)
    {this.white += x;}
    
    public void addBlack(int x)
    {this.black += x;}
    
    public int getGames()
    {return games;}
    
    public void setGames(int x)
    {this.games = x;}
    
    public String getColor()
    {return color;}
    
    public void setColor(String x)
    {this.color = x;}
    
    public int getTimesUnopposed()
    {return timesUnopposed;}
    
    public void setTimesUnopposed(int x)
    {this.timesUnopposed = x;}
}