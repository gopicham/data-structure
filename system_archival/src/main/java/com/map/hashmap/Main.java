/**
 * 
 */
package com.map.hashmap;

import java.util.Collection;
import java.util.Set;

/**
 * 
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NodeMap<Integer, String> map = new NodeMap<Integer, String>();
		System.out.println("map is empty:" + map.isEmpty());
		map.put(10, "tert");
		map.put(20, "gdg");
		map.put(30, "maplll");
		map.put(40, "bdcb");
		map.put(40, "sarewrt");
		map.put(50, "maplll");
		map.put(60, "xxxxxv");

		map.put(70, "tert");
		map.put(80, "gdg");
		map.put(90, "maplll");
		map.put(410, "bdcb");
		map.put(140, "sarewrt");
		map.put(150, "maplll");
		map.put(160, "xxxxxv");

		map.put(110, "tert");
		map.put(120, "gdg");
		map.put(130, "maplll");
		map.put(140, "bdcb");
		map.put(240, "sarewrt");
		map.put(450, "maplll");
		map.put(560, "xxxxxv");
		map.put(100, "9999");

		System.out.println("map size : " + map.size());

		System.out.println(map.toString());
		System.out.println("vale :" + map.get(10));
		System.out.println("vale :" + map.get(20));

		System.out.println("contains key  :" + map.containsKey(60));
		System.out.println("contains value:" + map.containsValue("gdg"));

		System.out.println("map size : " + map.size());
		System.out.println("map is empty:" + map.isEmpty());

		Set<Integer> keys = map.keySet();
		System.out.println("keys are : " + keys);

		Collection<String> values = map.values();
		System.out.println("values are :" + values);

		System.out.println(map.get(10));

		map.replace(100, "*yyyyyyyyyyyyyyy**");
		map.replace(100, "*****TtttTTTTTTTTTTTTTTTTTTTTTT**");

		map.putAll(1011, "******oooooo*******");

		map.putAll(1011, "******IIIII*******");
		map.putAll(1012, "******MMMMM*******");
		map.putAll(1012, "******LLLLL*******");
		map.remove(1011);
		Set<Integer> keys2 = map.keySet();
		System.out.println("keys are : " + keys2);
		Collection<String> value1s = map.values();
		System.out.println("values are :" + value1s);
	}

}
