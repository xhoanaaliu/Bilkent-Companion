

        package thecelestials.bilkentcompanion;

        import android.Manifest;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.graphics.Color;
        import android.net.Uri;
        import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

        import com.google.android.gms.appindexing.Action;
        import com.google.android.gms.appindexing.AppIndex;
        import com.google.android.gms.common.api.GoogleApiClient;
        import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import thecelestials.bilkentcompanion.DirectionFinder;
import thecelestials.bilkentcompanion.DirectionFinderListener;
import thecelestials.bilkentcompanion.Route;

        public class Building extends FragmentActivity implements OnMapReadyCallback, DirectionFinderListener {

            private GoogleMap mMap;
            private Button btnFindPath;
            private EditText etOrigin;
            private EditText etDestination;
            private List<Marker> originMarkers = new ArrayList<>();
            private List<Marker> destinationMarkers = new ArrayList<>();
            private List<Polyline> polylinePaths = new ArrayList<>();
            private ProgressDialog progressDialog;
            /**
             * ATTENTION: This was auto-generated to implement the App Indexing API.
             * See https://g.co/AppIndexing/AndroidStudio for more information.
             */
            private GoogleApiClient client;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_building);
                // Obtain the SupportMapFragment and get notified when the map is ready to be used.
                SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                        .findFragmentById(R.id.map);
                mapFragment.getMapAsync(this);

                btnFindPath = (Button) findViewById(R.id.btnFindPath);
                etOrigin = (EditText) findViewById(R.id.etOrigin);
                etDestination = (EditText) findViewById(R.id.etDestination);

                btnFindPath.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        sendRequest();
                    }
                });
                // ATTENTION: This was auto-generated to implement the App Indexing API.
                // See https://g.co/AppIndexing/AndroidStudio for more information.
                client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
            }

            private void sendRequest() {
                String origin = etOrigin.getText().toString();
                String destination = etDestination.getText().toString();
                if (origin.isEmpty()) {
                    Toast.makeText(this, "Please enter origin address!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (destination.isEmpty()) {
                    Toast.makeText(this, "Please enter destination address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    new DirectionFinder(this, origin, destination).execute();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }


            @Override
            public void onMapReady(GoogleMap googleMap) {
                mMap = googleMap;

                LatLng BilkentUniversity = new LatLng(39.8745300, 32.7473370);
                originMarkers.add(mMap.addMarker(new MarkerOptions()
                        .title("Bilkent University")
                        .position(BilkentUniversity)));

                LatLng ABuilding = new LatLng(39.8675853, 32.7494502);
                originMarkers.add(mMap.addMarker(new MarkerOptions()
                        .title("A Building")
                        .position(ABuilding)));

                LatLng ARLBuilding = new LatLng(39.8671600, 32.7484430);
                originMarkers.add(mMap.addMarker(new MarkerOptions()
                        .title("ARL Building")
                        .position(ARLBuilding)));

                LatLng BBuilding = new LatLng(39.8687830, 32.7481520);
                originMarkers.add(mMap.addMarker(new MarkerOptions()
                        .title("B Building")
                        .position(BBuilding)));

                LatLng BilkentLibrary = new LatLng(39.8703840, 32.7496990);
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(BilkentLibrary, 18));
                originMarkers.add(mMap.addMarker(new MarkerOptions()
                        .title("Bilkent Library")
                        .position(BilkentLibrary)));

                LatLng BilkentOdeon = new LatLng(39.8755680, 32.7522680);
                originMarkers.add(mMap.addMarker(new MarkerOptions()
                        .title("Bilkent Odeon")
                        .position(BilkentOdeon)));

                LatLng CBuilding = new LatLng(39.8713870, 32.7645100);
                originMarkers.add(mMap.addMarker(new MarkerOptions()
                        .title("C Building")
                        .position(CBuilding)));

                LatLng DBuilding = new LatLng(39.8704250, 32.7648800);
                originMarkers.add(mMap.addMarker(new MarkerOptions()
                        .title("D Building")
                        .position(DBuilding)));

                LatLng EABuilding = new LatLng(39.8712040, 32.7501640);
                originMarkers.add(mMap.addMarker(new MarkerOptions()
                        .title("EA Building")
                        .position(EABuilding)));

                LatLng EBBuilding = new LatLng(39.8713730, 32.7496890);
                originMarkers.add(mMap.addMarker(new MarkerOptions()
                        .title("EB Building")
                        .position(EBBuilding)));

                LatLng EEBuilding = new LatLng(39.8720630, 32.7509800);
                originMarkers.add(mMap.addMarker(new MarkerOptions()
                        .title("EE Building")
                        .position(EEBuilding)));

                LatLng FABuilding = new LatLng(39.8664280, 32.7500810);
                originMarkers.add(mMap.addMarker(new MarkerOptions()
                        .title("FA Building")
                        .position(FABuilding)));

                LatLng FBBuilding = new LatLng(39.8666490, 32.7497130);
                originMarkers.add(mMap.addMarker(new MarkerOptions()
                        .title("FB Building")
                        .position(FBBuilding)));

                LatLng FCBuilding = new LatLng(39.8670080, 32.7495470);
                originMarkers.add(mMap.addMarker(new MarkerOptions()
                        .title("FC Building")
                        .position(FCBuilding)));

                LatLng FDBuilding = new LatLng(39.8664290, 32.7492330);
                originMarkers.add(mMap.addMarker(new MarkerOptions()
                        .title("FD Building")
                        .position(FDBuilding)));

                LatLng FFBuilding = new LatLng(39.8657850, 32.7489350);
                originMarkers.add(mMap.addMarker(new MarkerOptions()
                        .title("FF Building")
                        .position(FFBuilding)));

                LatLng GBuilding = new LatLng(39.8686420, 32.7497650);
                originMarkers.add(mMap.addMarker(new MarkerOptions()
                        .title("G Building")
                        .position(GBuilding)));

                LatLng HBuilding = new LatLng(39.8680800, 32.7500440);
                originMarkers.add(mMap.addMarker(new MarkerOptions()
                        .title("H Building")
                        .position(HBuilding)));

                LatLng LABuilding = new LatLng(39.8692630, 32.7496970);
                originMarkers.add(mMap.addMarker(new MarkerOptions()
                        .title("LA Building")
                        .position(LABuilding)));

                LatLng LBBuilding = new LatLng(39.8693000, 32.7499920);
                originMarkers.add(mMap.addMarker(new MarkerOptions()
                        .title("LB Building")
                        .position(LBBuilding)));

                LatLng LCBuilding = new LatLng(39.8674330, 32.7495710);
                originMarkers.add(mMap.addMarker(new MarkerOptions()
                        .title("LC Building")
                        .position(LCBuilding)));

                LatLng NABuilding = new LatLng(39.8728710, 32.7634560);
                originMarkers.add(mMap.addMarker(new MarkerOptions()
                        .title("NA Building")
                        .position(NABuilding)));

                LatLng NBBuilding = new LatLng(39.8732480, 32.7629700);
                originMarkers.add(mMap.addMarker(new MarkerOptions()
                        .title("NB Building")
                        .position(NBBuilding)));

                LatLng NCBuilding = new LatLng(39.8728400, 32.7629040);
                originMarkers.add(mMap.addMarker(new MarkerOptions()
                        .title("NC Building")
                        .position(NCBuilding)));

                LatLng PBuilding = new LatLng(39.8691570, 32.7550430);
                originMarkers.add(mMap.addMarker(new MarkerOptions()
                        .title("P Building")
                        .position(PBuilding)));

                LatLng RABuilding = new LatLng(39.8745890, 32.7612630);
                originMarkers.add(mMap.addMarker(new MarkerOptions()
                        .title("RA Building")
                        .position(RABuilding)));

                LatLng RBBuilding = new LatLng(39.8745970, 32.7618600);
                originMarkers.add(mMap.addMarker(new MarkerOptions()
                        .title("RB Building")
                        .position(RBBuilding)));

                LatLng RCBuilding = new LatLng(39.8743750, 32.7619580);
                originMarkers.add(mMap.addMarker(new MarkerOptions()
                        .title("RC Building")
                        .position(RCBuilding)));

                LatLng RDBuilding = new LatLng(39.8741950, 32.7620560);
                originMarkers.add(mMap.addMarker(new MarkerOptions()
                        .title("RD Building")
                        .position(RDBuilding)));

                LatLng REBuilding = new LatLng(39.8748280, 32.7616580);
                originMarkers.add(mMap.addMarker(new MarkerOptions()
                        .title("RE Building")
                        .position(REBuilding)));

                LatLng SABuilding = new LatLng(39.8675910, 32.7483740);
                originMarkers.add(mMap.addMarker(new MarkerOptions()
                        .title("SA Building")
                        .position(SABuilding)));

                LatLng SBBuilding = new LatLng(39.8682890, 32.7482510);
                originMarkers.add(mMap.addMarker(new MarkerOptions()
                        .title("SB Building")
                        .position(SBBuilding)));

                LatLng TBuilding = new LatLng(39.8682810, 32.7493270);
                originMarkers.add(mMap.addMarker(new MarkerOptions()
                        .title("T Building")
                        .position(TBuilding)));

                LatLng VBuilding = new LatLng(39.8669970, 32.7501530);
                originMarkers.add(mMap.addMarker(new MarkerOptions()
                        .title("SB Building")
                        .position(VBuilding)));


                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                mMap.setMyLocationEnabled(true);

            }


            @Override
            public void onDirectionFinderStart() {
                progressDialog = ProgressDialog.show(this, "Please wait.",
                        "Finding direction..!", true);

                if (originMarkers != null) {
                    for (Marker marker : originMarkers) {
                        marker.remove();
                    }
                }

                if (destinationMarkers != null) {
                    for (Marker marker : destinationMarkers) {
                        marker.remove();
                    }
                }

                if (polylinePaths != null) {
                    for (Polyline polyline : polylinePaths) {
                        polyline.remove();
                    }
                }
            }

            @Override
            public void onDirectionFinderSuccess(List<Route> routes) {
                progressDialog.dismiss();
                polylinePaths = new ArrayList<>();
                originMarkers = new ArrayList<>();
                destinationMarkers = new ArrayList<>();

                for (Route route : routes) {
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(route.startLocation, 16));
                    ((TextView) findViewById(R.id.tvDuration)).setText(route.duration.text);
                    ((TextView) findViewById(R.id.tvDistance)).setText(route.distance.text);

                    originMarkers.add(mMap.addMarker(new MarkerOptions()
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.start_blue))
                            .title(route.startAddress)
                            .position(route.startLocation)));
                    destinationMarkers.add(mMap.addMarker(new MarkerOptions()
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.end_green))
                            .title(route.endAddress)
                            .position(route.endLocation)));

                    PolylineOptions polylineOptions = new PolylineOptions().
                            geodesic(true).
                            color(Color.BLUE).
                            width(10);

                    for (int i = 0; i < route.points.size(); i++)
                        polylineOptions.add(route.points.get(i));

                    polylinePaths.add(mMap.addPolyline(polylineOptions));
                }
            }

            @Override
            public void onStart() {
                super.onStart();

                // ATTENTION: This was auto-generated to implement the App Indexing API.
                // See https://g.co/AppIndexing/AndroidStudio for more information.
                client.connect();
                Action viewAction = Action.newAction(
                        Action.TYPE_VIEW, // TODO: choose an action type.
                        "Building Page", // TODO: Define a title for the content shown.
                        // TODO: If you have web page content that matches this app activity's content,
                        // make sure this auto-generated web page URL is correct.
                        // Otherwise, set the URL to null.
                        Uri.parse("http://host/path"),
                        // TODO: Make sure this auto-generated app URL is correct.
                        Uri.parse("android-app://thecelestials.bilkentcompanion/http/host/path")
                );
                AppIndex.AppIndexApi.start(client, viewAction);
            }

            @Override
            public void onStop() {
                super.onStop();

                // ATTENTION: This was auto-generated to implement the App Indexing API.
                // See https://g.co/AppIndexing/AndroidStudio for more information.
                Action viewAction = Action.newAction(
                        Action.TYPE_VIEW, // TODO: choose an action type.
                        "Building Page", // TODO: Define a title for the content shown.
                        // TODO: If you have web page content that matches this app activity's content,
                        // make sure this auto-generated web page URL is correct.
                        // Otherwise, set the URL to null.
                        Uri.parse("http://host/path"),
                        // TODO: Make sure this auto-generated app URL is correct.
                        Uri.parse("android-app://thecelestials.bilkentcompanion/http/host/path")
                );
                AppIndex.AppIndexApi.end(client, viewAction);
                client.disconnect();
            }
        }
