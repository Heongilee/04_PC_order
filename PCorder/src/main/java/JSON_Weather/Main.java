package JSON_Weather;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

/* 
 * Main DTO Class
 * */
public class Main {
    private double temp;
    private double feelsLike;
    private long tempMin;
    private long tempMax;
    private long pressure;
    private long humidity;

    @JsonProperty("temp")
    public double getTemp() { return temp; }
    @JsonProperty("temp")
    public void setTemp(double value) { this.temp = value; }

    @JsonProperty("feels_like")
    public double getFeelsLike() { return feelsLike; }
    @JsonProperty("feels_like")
    public void setFeelsLike(double value) { this.feelsLike = value; }

    @JsonProperty("temp_min")
    public long getTempMin() { return tempMin; }
    @JsonProperty("temp_min")
    public void setTempMin(long value) { this.tempMin = value; }

    @JsonProperty("temp_max")
    public long getTempMax() { return tempMax; }
    @JsonProperty("temp_max")
    public void setTempMax(long value) { this.tempMax = value; }

    @JsonProperty("pressure")
    public long getPressure() { return pressure; }
    @JsonProperty("pressure")
    public void setPressure(long value) { this.pressure = value; }

    @JsonProperty("humidity")
    public long getHumidity() { return humidity; }
    @JsonProperty("humidity")
    public void setHumidity(long value) { this.humidity = value; }
}
