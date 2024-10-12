# Custom phone home page
Kiosk like home app that can't be exited.  Features and apps can be added/removed later.

The original goal is to provide only the basic phone functions - Phone calls and texts - for users with low self-control from all the distractions that phones can provide.  

Attempting to create the app using Android Studio - Kotlin

High-Level Plan:
Flutter UI: Design a simple interface to display phone functions.
Android Native Code: Interact with the device policy APIs via platform channels in Flutter (as this is Android specific).
Restricting Device: Write a native Android service in Kotlin/Java using the DevicePolicyManager to lock down the phone's features.
Grant Permissions: Request necessary permissions for phone and SMS access.

Key APIs Needed:
DevicePolicyManager:

To enforce the kiosk mode, restrict access, and manage apps.
Example:
java
DevicePolicyManager dpm = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);
dpm.setLockTaskPackages(adminComponentName, new String[]{getPackageName()});
Telephony APIs:

For accessing phone functions (calling, texting) from within the Flutter app.
Intent to Handle Phone Calls and SMS:

For making phone calls and sending texts, handle intents in Android, which can be triggered from Flutter using platform channels.
dart
// Flutter example for triggering a phone call
import 'package:url_launcher/url_launcher.dart';

launchPhone(String phoneNumber) async {
  var url = "tel:$phoneNumber";
  if (await canLaunch(url)) {
    await launch(url);
  } else {
    throw 'Could not launch $url';
  }
}
Additional Considerations:
Custom Launcher: May need to replace the default launcher to ensure the device is locked to only the "home" app.
Admin Privileges: Need to provision the app as a device owner during the setup phase to ensure it has sufficient privileges to enforce kiosk mode.
