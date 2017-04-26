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
public class Image
{
    private String name;
    private String type;
    private String base64;

    public Image() {
    }

    public Image(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBase64()
    {
        return base64;
    }

    public void setBase64(String base64)
    {
        this.base64 = base64;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }
}
