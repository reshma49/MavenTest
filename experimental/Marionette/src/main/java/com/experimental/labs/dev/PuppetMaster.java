package com.experimental.labs.dev;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PuppetMaster {

    private List <Puppet> toys = new ArrayList<Puppet>();

    public PuppetMaster () {
	toys.add(new Karasu());
	toys.add(new Kuroari());
	toys.add(new Sanshouo());
    }

    @Override
    public String toString(){
	String ret = "";
	for (Puppet p : toys){
 	    ret += p.toString();
	}
	return ret;
    }

    public static void main( String[] args ) {
        System.out.println( "Hello World!" );

	PuppetMaster controller = new PuppetMaster();
	System.out.println(controller.toString());
    }
}
