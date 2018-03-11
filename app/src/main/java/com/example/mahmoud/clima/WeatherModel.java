package com.example.mahmoud.clima;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Mahmoud on 3/10/2018.
 */

public class WeatherModel {
    private String city;
    private String mIconName;
    private int mCondition;
    private String mTemperature;

    public String getCity() {
        return city;
    }

    public String getmIconName() {
        return mIconName;
    }

    public void setmIconName(String mIconName) {
        this.mIconName = mIconName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getmTemperature() {
        return mTemperature;
    }

    public void setmTemperature(String mTemperature) {
        this.mTemperature = mTemperature;
    }

    private static String  updateWeatherIcon(int condition)
    {

        if (condition >= 0 && condition < 300) {
            return "tstorm1";
        } else if (condition >= 300 && condition < 500) {
            return "light_rain";
        } else if (condition >= 500 && condition < 600) {
            return "shower3";
        } else if (condition >= 600 && condition <= 700) {
            return "snow4";
        } else if (condition >= 701 && condition <= 771) {
            return "fog";
        } else if (condition >= 772 && condition < 800) {
            return "tstorm3";
        } else if (condition == 800) {
            return "sunny";
        } else if (condition >= 801 && condition <= 804) {
            return "cloudy2";
        } else if (condition >= 900 && condition <= 902) {
            return "tstorm3";
        } else if (condition == 903) {
            return "snow5";
        } else if (condition == 904) {
            return "sunny";
        } else if (condition >= 905 && condition <= 1000) {
            return "tstorm3";
        }

        return "dunno";
    }

    public static WeatherModel fromJson(JSONObject jsonObject) {
        WeatherModel weatherData = new WeatherModel();
        try {

            weatherData.city = jsonObject.getString("name");
            weatherData.mCondition = jsonObject.getJSONArray("weather").getJSONObject(0).getInt("id");
            weatherData.mIconName = updateWeatherIcon(weatherData.mCondition);

            double tempResult = jsonObject.getJSONObject("main").getDouble("temp") - 273.15;
            int roundedValue = (int) Math.rint(tempResult);

            weatherData.mTemperature = Integer.toString(roundedValue);


        }catch (JSONException e)
        {

        }
        return weatherData;

    }
}
