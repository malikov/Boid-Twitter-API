package com.teamboid.twitterapi.status.entity.hashtag;

import org.json.JSONArray;
import org.json.JSONException;

import org.json.JSONObject;
import com.teamboid.twitterapi.utilities.Utils;

import java.io.Serializable;

/**
 * Handles parsing JSON and assigning values to a {@link HashtagEntity} interface.
 *
 * @author Aidan Follestad
 */
public class HashtagEntityJSON implements HashtagEntity, Serializable {

	private static final long serialVersionUID = 8321279745736096641L;

	public HashtagEntityJSON(JSONObject json) throws JSONException {
        if(!json.isNull("text")) {
            _text = Utils.unescape(json.getString("text"));
        }
        JSONArray indices = json.getJSONArray("indices");
        _startIndex = indices.getInt(0);
        _endIndex = indices.getInt(1);
    }

    private String _text;
    private int _startIndex;
    private int _endIndex;

    @Override
    public String getText() { return _text; }

    @Override
    public int getStartIndex() { return _startIndex; }

    @Override
    public int getEndIndex() { return _endIndex; }
}
