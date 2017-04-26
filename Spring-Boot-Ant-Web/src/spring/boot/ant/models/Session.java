/*
 * Copyright (c) 2017
 * AlphaGate Automatisierungstechnik, Rankweil, Austria  * 
 * @author      original: abo, last edit: $Author$
 * @version     $Id$
 */
package spring.boot.ant.models;

/**
 *
 * @author abosancic
 */
public class Session
{

    private String session_id;
    private String start_time;
    private String end_time;
    private String operator;
    private String sample_type;
    private String growth_unit;
    private String doubtful_count;
    private String error_count;
    private String no_growth_count;
    private String probable_count;
    private String reincubate_count;
    private String review_count;
    private String total_count;

    public String getSession_id()
    {
        return session_id;
    }

    public void setSession_id(String session_id)
    {
        this.session_id = session_id;
    }

    public String getStart_time()
    {
        return start_time;
    }

    public void setStart_time(String start_time)
    {
        this.start_time = start_time;
    }

    public String getEnd_time()
    {
        return end_time;
    }

    public void setEnd_time(String end_time)
    {
        this.end_time = end_time;
    }

    public String getOperator()
    {
        return operator;
    }

    public void setOperator(String operator)
    {
        this.operator = operator;
    }

    public String getSample_type()
    {
        return sample_type;
    }

    public void setSample_type(String sample_type)
    {
        this.sample_type = sample_type;
    }

    public String getGrowth_unit()
    {
        return growth_unit;
    }

    public void setGrowth_unit(String growth_unit)
    {
        this.growth_unit = growth_unit;
    }

    public String getDoubtful_count()
    {
        return doubtful_count;
    }

    public void setDoubtful_count(String doubtful_count)
    {
        this.doubtful_count = doubtful_count;
    }

    public String getError_count()
    {
        return error_count;
    }

    public void setError_count(String error_count)
    {
        this.error_count = error_count;
    }

    public String getNo_growth_count()
    {
        return no_growth_count;
    }

    public void setNo_growth_count(String no_growth_count)
    {
        this.no_growth_count = no_growth_count;
    }

    public String getProbable_count()
    {
        return probable_count;
    }

    public void setProbable_count(String probable_count)
    {
        this.probable_count = probable_count;
    }

    public String getReincubate_count()
    {
        return reincubate_count;
    }

    public void setReincubate_count(String reincubate_count)
    {
        this.reincubate_count = reincubate_count;
    }

    public String getReview_count()
    {
        return review_count;
    }

    public void setReview_count(String review_count)
    {
        this.review_count = review_count;
    }

    public String getTotal_count()
    {
        return total_count;
    }

    public void setTotal_count(String total_count)
    {
        this.total_count = total_count;
    }
    
    
    
}
