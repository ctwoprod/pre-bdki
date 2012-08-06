package org.fernandez.roberto.bdki.helper;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;

@Component
public class JsonUtil<T> {

	private Class clazz = null;

	public void setT(Class clazz) {
		// TODO Auto-generated method stub
		this.clazz = clazz;
	}

	/**
	 * Get list of T from request.
	 * 
	 * @param data
	 *            - json data from request
	 * @return list of T
	 */
	public List<T> getTsFromRequest(Object data) {

		List<T> list;

		// it is an array - have to cast to array object
		if (data.toString().indexOf('[') > -1) {

			list = getListTFromJSON(data);

		} else { // it is only one object - cast to object/bean

			T obj = getTFromJSON(data);

			list = new ArrayList<T>();
			list.add(obj);
		}

		return list;
	}

	/**
	 * Transform json data format into T object
	 * 
	 * @param data
	 *            - json data from request
	 * @return
	 */
	private T getTFromJSON(Object data) {
		JSONObject jsonObject = JSONObject.fromObject(data);
		T newT = (T) JSONObject.toBean(jsonObject, clazz);
		return newT;
	}

	/**
	 * Transform json data format into list of T objects
	 * 
	 * @param data
	 *            - json data from request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private List<T> getListTFromJSON(Object data) {
		JSONArray jsonArray = JSONArray.fromObject(data);
		List<T> newT = (List<T>) JSONArray.toCollection(jsonArray, clazz);
		return newT;
	}

	/**
	 * Tranform array of numbers in json data format into list of Integer
	 * 
	 * @param data
	 *            - json data from request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Long> getListIdFromJSON(Object data) {
		JSONArray jsonArray = JSONArray.fromObject(data);
		List<Long> ids = (List<Long>) JSONArray.toCollection(jsonArray,
				Integer.class);
		return ids;
	}
}
