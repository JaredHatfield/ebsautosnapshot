package com.unitvectory.ebsautosnapshot.model;

public class EbsAutoSnapshotConfig {

	private String awsPublicKey;

	private String awsPrivateKey;

	public EbsAutoSnapshotConfig() {
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
