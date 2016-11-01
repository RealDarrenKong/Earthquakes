/**
 * (C) 2016. Darren Kong [All rights reserved]. This product and related documentation are protected by
 * copyright restricting its use, copying, distribution, and decompilation. No part of this product or related
 * documentation may be reproduced in any form by any means without prior written authorization of Darren Kong
 * . Unless otherwise arranged, third parties may not have access to this product or related documents.
 */

package au.com.darrenkong.earthquakes.model;

/**
 * Created by dkong on 1/11/2016.
 */
public class Earthquakes {

    public int count;
    public Earthquake[] earthquakes;

    public class Earthquake {
        public String src;
        public String eqid;
        public String timedate;
        public String lat;
        public String lon;
        public String magnitude;
        public String depth;
        public String region;
    }
}
