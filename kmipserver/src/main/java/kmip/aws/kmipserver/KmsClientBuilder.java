package kmip.aws.kmipserver;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.kms.AWSKMS;
import com.amazonaws.services.kms.AWSKMSClientBuilder;
import com.amazonaws.services.certificatemanager.AWSCertificateManagerClientBuilder;
import com.amazonaws.services.certificatemanager.AWSCertificateManager;

import kmip.aws.kmipserver.objects.Credentials;

public class KmsClientBuilder {

    public AWSKMS buildKmsClient(){
        Credentials credentials = new Credentials();
        BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials(credentials.getAccessKeyId(), credentials.getSecretAccessKey());

        return AWSKMSClientBuilder.standard()
        .withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials))
        .withRegion(Regions.US_EAST_2)
        .build();
    }
        
    public AWSCertificateManager buildAcmClient()
    {
        Credentials credentials = new Credentials();
        BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials(credentials.getAccessKeyId(), credentials.getSecretAccessKey());

        return AWSCertificateManager.standard()
            .withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials))
            .withRegion(Regions.US_EAST_2)
            .build();
    }
}
