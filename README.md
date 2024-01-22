# gcp-document-

[Google Authentication and Project ID](https://github.com/googleapis/google-cloud-java/blob/main/README.md)
# from terminal
export GOOGLE_APPLICATION_CREDENTIALS="/path/to/your/service-account-key.json"
# or Pass this as environment variable to java process ( Path to service account)
GOOGLE_APPLICATION_CREDENTIALS="/path/to/your/service-account-key.json"

Application Default Credentials
If no credentials are provided, google-cloud will attempt to detect them from the environment using GoogleCredentials.getApplicationDefault() which will search for Application Default Credentials in the following locations (in order):

The credentials file pointed to by the GOOGLE_APPLICATION_CREDENTIALS environment variable
Credentials provided by the Google Cloud SDK gcloud auth application-default login command  (gcloud auth login)
Google App Engine built-in credentials
Google Cloud Shell built-in credentials
Google Compute Engine built-in credentials

Specifying a Project ID
Most google-cloud libraries require a project ID. There are multiple ways to specify this project ID.

When using google-cloud libraries from within Compute/App Engine, there's no need to specify a project ID. It is automatically inferred from the production environment.
When using google-cloud elsewhere, you can do one of the following:
Supply the project ID when building the service options. For example, to use Datastore from a project with ID "PROJECT_ID", you can write:

Datastore datastore = DatastoreOptions.newBuilder().setProjectId("PROJECT_ID").build().getService();
Specify the environment variable GOOGLE_CLOUD_PROJECT to be your desired project ID.

Set the project ID using the Google Cloud SDK. To use the SDK, download the SDK if you haven't already, and set the project ID from the command line. For example:

gcloud config set project PROJECT_ID
google-cloud determines the project ID from the following sources in the listed order, stopping once it finds a value:

The project ID supplied when building the service options
Project ID specified by the environment variable GOOGLE_CLOUD_PROJECT
The App Engine / Compute Engine project ID
The project ID specified in the JSON credentials file pointed by the GOOGLE_APPLICATION_CREDENTIALS environment variable
The Google Cloud SDK project ID
In cases where the library may expect a project ID explicitly, we provide a helper that can provide the inferred project ID:

import com.google.cloud.ServiceOptions;
...
String projectId = ServiceOptions.getDefaultProjectId();
