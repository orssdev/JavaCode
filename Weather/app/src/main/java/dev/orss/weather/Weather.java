package dev.orss.weather;

import io.github.cdimascio.dotenv.Dotenv;

public class Weather 
{
    private String url;
    private String location;
    private String apikey;

    public Weather()
    {
        Dotenv dotenv = Dotenv.load();

        this.url = "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=imperial";
        this.apikey = dotenv.get("API_KEY");
        this.location = "";
    }

    public void setLocation(String location)
    {
        if(location != null)
        {
            this.location = location;
        }
        else
        {
            this.location = "";
        }
    }

    public String getURl()
    {
        return String.format(this.url, this.location, this.apikey);
    }
}
