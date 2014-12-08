package com.unitvectory.ebsautosnapshot.model;

import com.amazonaws.util.json.JSONException;
import com.amazonaws.util.json.JSONObject;

public class EbsAutoSnapshotConfig {

	private String awsPublicKey;

	private String awsPrivateKey;

	public EbsAutoSnapshotConfig(JSONObject jsonObject) throws JSONException {
		this.awsPublicKey = jsonObject.getString("awsPublicKey");
		this.awsPrivateKey = jsonObject.getString("awsPrivateKey");
	}

	/**
	 * @return the awsPublicKey
	 */
	public String getAwsPublicKey() {
		return awsPublicKey;
	}

	/**
	 * @return the awsPrivateKey
	 */
	public String getAwsPrivateKey() {
		return awsPrivateKey;
	}
}
