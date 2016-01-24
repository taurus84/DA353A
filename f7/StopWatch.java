package f7;
/**
 * Klassen kan anv�ndas f�r att m�ta tid. Metoden <code>start()</code> anropas
 * f�r att starta tidtagningen och metoden <code>stop()</code> anropas f�r att
 * avsluta tidtagningen.
 * @author Rolf Axelsson
 */
public class StopWatch {
    private long startTime;
    private long stoptime;
    private boolean start = false;
    
    /**
     * Anropa <code>start()</code> d� tidtagningen ska b�rja.
     */
    public void start() {
    	this.startTime = System.currentTimeMillis();
        this.stoptime = this.startTime;
        start = true;
    }
    
    /**
     * Anropa <code>stop()</code> d� tidtagningen ska avslutas.
     */
    public void stopp() {
    	this.stoptime = System.currentTimeMillis();
    }
    
    /**
     * Metoden returnerar antalet millisekunder det g�tt mellan senaste anropet
     * till <code>start()</code>  och senaste anropet till <code>stop()</code>.
     * @return antalet millisekunder det g�tt mellan senaste anropet till
     *         <code>start()</code>  och senaste anropet till <code>stop()</code>.<br>
     *         Om <code>start()</code> ej anropats returneras v�rdet 0.<br>
     *         Om <code>stop()</code> ej anropats efter <code>start()</code>
     *         returneras v�rdet 0.
     */
    public long getMilliSeconds() {
        if(start==true)
            return (this.stoptime-this.startTime);
        else
            return 0;
    }
    
    /**
     * Metoden returnerar antalet sekunder det g�tt mellan senaste anropet
     * till <code>start()</code>  och senaste anropet till <code>stop()</code>.
     * @return antalet sekunder det g�tt mellan senaste anropet till
     *         <code>start()</code>  och senaste anropet till <code>stop()</code>.<br>
     *         Om <code>start()</code> ej anropats returneras v�rdet 0.<br>
     *         Om <code>stop()</code> ej anropats efter <code>start()</code>
     *         returneras v�rdet 0.
     */
    public double getSeconds() {
        return getMilliSeconds()/1000.0;
    }
}