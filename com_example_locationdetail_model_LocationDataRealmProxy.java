package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ImportFlag;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.NativeContext;
import io.realm.internal.OsList;
import io.realm.internal.OsMap;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.OsSet;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.internal.core.NativeRealmAny;
import io.realm.internal.objectstore.OsObjectBuilder;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class com_example_locationdetail_model_LocationDataRealmProxy extends com.example.locationdetail.model.LocationData
    implements RealmObjectProxy, com_example_locationdetail_model_LocationDataRealmProxyInterface {

    static final class LocationDataColumnInfo extends ColumnInfo {
        long latitudeColKey;
        long longitudeColKey;
        long countryColKey;
        long LocalityColKey;
        long AddressColKey;

        LocationDataColumnInfo(OsSchemaInfo schemaInfo) {
            super(5);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("LocationData");
            this.latitudeColKey = addColumnDetails("latitude", "latitude", objectSchemaInfo);
            this.longitudeColKey = addColumnDetails("longitude", "longitude", objectSchemaInfo);
            this.countryColKey = addColumnDetails("country", "country", objectSchemaInfo);
            this.LocalityColKey = addColumnDetails("Locality", "Locality", objectSchemaInfo);
            this.AddressColKey = addColumnDetails("Address", "Address", objectSchemaInfo);
        }

        LocationDataColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new LocationDataColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final LocationDataColumnInfo src = (LocationDataColumnInfo) rawSrc;
            final LocationDataColumnInfo dst = (LocationDataColumnInfo) rawDst;
            dst.latitudeColKey = src.latitudeColKey;
            dst.longitudeColKey = src.longitudeColKey;
            dst.countryColKey = src.countryColKey;
            dst.LocalityColKey = src.LocalityColKey;
            dst.AddressColKey = src.AddressColKey;
        }
    }

    private static final String NO_ALIAS = "";
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private LocationDataColumnInfo columnInfo;
    private ProxyState<com.example.locationdetail.model.LocationData> proxyState;

    com_example_locationdetail_model_LocationDataRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (LocationDataColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.example.locationdetail.model.LocationData>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$latitude() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.latitudeColKey);
    }

    @Override
    public void realmSet$latitude(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'latitude' to null.");
            }
            row.getTable().setString(columnInfo.latitudeColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'latitude' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.latitudeColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$longitude() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.longitudeColKey);
    }

    @Override
    public void realmSet$longitude(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'longitude' to null.");
            }
            row.getTable().setString(columnInfo.longitudeColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'longitude' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.longitudeColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$country() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.countryColKey);
    }

    @Override
    public void realmSet$country(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'country' to null.");
            }
            row.getTable().setString(columnInfo.countryColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'country' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.countryColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$Locality() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.LocalityColKey);
    }

    @Override
    public void realmSet$Locality(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'Locality' to null.");
            }
            row.getTable().setString(columnInfo.LocalityColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'Locality' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.LocalityColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$Address() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.AddressColKey);
    }

    @Override
    public void realmSet$Address(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'Address' to null.");
            }
            row.getTable().setString(columnInfo.AddressColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'Address' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.AddressColKey, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(NO_ALIAS, "LocationData", false, 5, 0);
        builder.addPersistedProperty(NO_ALIAS, "latitude", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "longitude", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "country", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "Locality", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "Address", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static LocationDataColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new LocationDataColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "LocationData";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "LocationData";
    }

    @SuppressWarnings("cast")
    public static com.example.locationdetail.model.LocationData createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.example.locationdetail.model.LocationData obj = realm.createObjectInternal(com.example.locationdetail.model.LocationData.class, true, excludeFields);

        final com_example_locationdetail_model_LocationDataRealmProxyInterface objProxy = (com_example_locationdetail_model_LocationDataRealmProxyInterface) obj;
        if (json.has("latitude")) {
            if (json.isNull("latitude")) {
                objProxy.realmSet$latitude(null);
            } else {
                objProxy.realmSet$latitude((String) json.getString("latitude"));
            }
        }
        if (json.has("longitude")) {
            if (json.isNull("longitude")) {
                objProxy.realmSet$longitude(null);
            } else {
                objProxy.realmSet$longitude((String) json.getString("longitude"));
            }
        }
        if (json.has("country")) {
            if (json.isNull("country")) {
                objProxy.realmSet$country(null);
            } else {
                objProxy.realmSet$country((String) json.getString("country"));
            }
        }
        if (json.has("Locality")) {
            if (json.isNull("Locality")) {
                objProxy.realmSet$Locality(null);
            } else {
                objProxy.realmSet$Locality((String) json.getString("Locality"));
            }
        }
        if (json.has("Address")) {
            if (json.isNull("Address")) {
                objProxy.realmSet$Address(null);
            } else {
                objProxy.realmSet$Address((String) json.getString("Address"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.locationdetail.model.LocationData createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.example.locationdetail.model.LocationData obj = new com.example.locationdetail.model.LocationData();
        final com_example_locationdetail_model_LocationDataRealmProxyInterface objProxy = (com_example_locationdetail_model_LocationDataRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("latitude")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$latitude((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$latitude(null);
                }
            } else if (name.equals("longitude")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$longitude((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$longitude(null);
                }
            } else if (name.equals("country")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$country((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$country(null);
                }
            } else if (name.equals("Locality")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$Locality((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$Locality(null);
                }
            } else if (name.equals("Address")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$Address((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$Address(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    static com_example_locationdetail_model_LocationDataRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.example.locationdetail.model.LocationData.class), false, Collections.<String>emptyList());
        io.realm.com_example_locationdetail_model_LocationDataRealmProxy obj = new io.realm.com_example_locationdetail_model_LocationDataRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.example.locationdetail.model.LocationData copyOrUpdate(Realm realm, LocationDataColumnInfo columnInfo, com.example.locationdetail.model.LocationData object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.example.locationdetail.model.LocationData) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.example.locationdetail.model.LocationData copy(Realm realm, LocationDataColumnInfo columnInfo, com.example.locationdetail.model.LocationData newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.locationdetail.model.LocationData) cachedRealmObject;
        }

        com_example_locationdetail_model_LocationDataRealmProxyInterface unmanagedSource = (com_example_locationdetail_model_LocationDataRealmProxyInterface) newObject;

        Table table = realm.getTable(com.example.locationdetail.model.LocationData.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.latitudeColKey, unmanagedSource.realmGet$latitude());
        builder.addString(columnInfo.longitudeColKey, unmanagedSource.realmGet$longitude());
        builder.addString(columnInfo.countryColKey, unmanagedSource.realmGet$country());
        builder.addString(columnInfo.LocalityColKey, unmanagedSource.realmGet$Locality());
        builder.addString(columnInfo.AddressColKey, unmanagedSource.realmGet$Address());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_example_locationdetail_model_LocationDataRealmProxy managedCopy = newProxyInstance(realm, row);
        cache.put(newObject, managedCopy);

        return managedCopy;
    }

    public static long insert(Realm realm, com.example.locationdetail.model.LocationData object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.example.locationdetail.model.LocationData.class);
        long tableNativePtr = table.getNativePtr();
        LocationDataColumnInfo columnInfo = (LocationDataColumnInfo) realm.getSchema().getColumnInfo(com.example.locationdetail.model.LocationData.class);
        long objKey = OsObject.createRow(table);
        cache.put(object, objKey);
        String realmGet$latitude = ((com_example_locationdetail_model_LocationDataRealmProxyInterface) object).realmGet$latitude();
        if (realmGet$latitude != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.latitudeColKey, objKey, realmGet$latitude, false);
        }
        String realmGet$longitude = ((com_example_locationdetail_model_LocationDataRealmProxyInterface) object).realmGet$longitude();
        if (realmGet$longitude != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.longitudeColKey, objKey, realmGet$longitude, false);
        }
        String realmGet$country = ((com_example_locationdetail_model_LocationDataRealmProxyInterface) object).realmGet$country();
        if (realmGet$country != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.countryColKey, objKey, realmGet$country, false);
        }
        String realmGet$Locality = ((com_example_locationdetail_model_LocationDataRealmProxyInterface) object).realmGet$Locality();
        if (realmGet$Locality != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.LocalityColKey, objKey, realmGet$Locality, false);
        }
        String realmGet$Address = ((com_example_locationdetail_model_LocationDataRealmProxyInterface) object).realmGet$Address();
        if (realmGet$Address != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.AddressColKey, objKey, realmGet$Address, false);
        }
        return objKey;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.locationdetail.model.LocationData.class);
        long tableNativePtr = table.getNativePtr();
        LocationDataColumnInfo columnInfo = (LocationDataColumnInfo) realm.getSchema().getColumnInfo(com.example.locationdetail.model.LocationData.class);
        com.example.locationdetail.model.LocationData object = null;
        while (objects.hasNext()) {
            object = (com.example.locationdetail.model.LocationData) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            long objKey = OsObject.createRow(table);
            cache.put(object, objKey);
            String realmGet$latitude = ((com_example_locationdetail_model_LocationDataRealmProxyInterface) object).realmGet$latitude();
            if (realmGet$latitude != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.latitudeColKey, objKey, realmGet$latitude, false);
            }
            String realmGet$longitude = ((com_example_locationdetail_model_LocationDataRealmProxyInterface) object).realmGet$longitude();
            if (realmGet$longitude != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.longitudeColKey, objKey, realmGet$longitude, false);
            }
            String realmGet$country = ((com_example_locationdetail_model_LocationDataRealmProxyInterface) object).realmGet$country();
            if (realmGet$country != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.countryColKey, objKey, realmGet$country, false);
            }
            String realmGet$Locality = ((com_example_locationdetail_model_LocationDataRealmProxyInterface) object).realmGet$Locality();
            if (realmGet$Locality != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.LocalityColKey, objKey, realmGet$Locality, false);
            }
            String realmGet$Address = ((com_example_locationdetail_model_LocationDataRealmProxyInterface) object).realmGet$Address();
            if (realmGet$Address != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.AddressColKey, objKey, realmGet$Address, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.locationdetail.model.LocationData object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.example.locationdetail.model.LocationData.class);
        long tableNativePtr = table.getNativePtr();
        LocationDataColumnInfo columnInfo = (LocationDataColumnInfo) realm.getSchema().getColumnInfo(com.example.locationdetail.model.LocationData.class);
        long objKey = OsObject.createRow(table);
        cache.put(object, objKey);
        String realmGet$latitude = ((com_example_locationdetail_model_LocationDataRealmProxyInterface) object).realmGet$latitude();
        if (realmGet$latitude != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.latitudeColKey, objKey, realmGet$latitude, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.latitudeColKey, objKey, false);
        }
        String realmGet$longitude = ((com_example_locationdetail_model_LocationDataRealmProxyInterface) object).realmGet$longitude();
        if (realmGet$longitude != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.longitudeColKey, objKey, realmGet$longitude, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.longitudeColKey, objKey, false);
        }
        String realmGet$country = ((com_example_locationdetail_model_LocationDataRealmProxyInterface) object).realmGet$country();
        if (realmGet$country != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.countryColKey, objKey, realmGet$country, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.countryColKey, objKey, false);
        }
        String realmGet$Locality = ((com_example_locationdetail_model_LocationDataRealmProxyInterface) object).realmGet$Locality();
        if (realmGet$Locality != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.LocalityColKey, objKey, realmGet$Locality, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.LocalityColKey, objKey, false);
        }
        String realmGet$Address = ((com_example_locationdetail_model_LocationDataRealmProxyInterface) object).realmGet$Address();
        if (realmGet$Address != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.AddressColKey, objKey, realmGet$Address, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.AddressColKey, objKey, false);
        }
        return objKey;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.locationdetail.model.LocationData.class);
        long tableNativePtr = table.getNativePtr();
        LocationDataColumnInfo columnInfo = (LocationDataColumnInfo) realm.getSchema().getColumnInfo(com.example.locationdetail.model.LocationData.class);
        com.example.locationdetail.model.LocationData object = null;
        while (objects.hasNext()) {
            object = (com.example.locationdetail.model.LocationData) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            long objKey = OsObject.createRow(table);
            cache.put(object, objKey);
            String realmGet$latitude = ((com_example_locationdetail_model_LocationDataRealmProxyInterface) object).realmGet$latitude();
            if (realmGet$latitude != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.latitudeColKey, objKey, realmGet$latitude, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.latitudeColKey, objKey, false);
            }
            String realmGet$longitude = ((com_example_locationdetail_model_LocationDataRealmProxyInterface) object).realmGet$longitude();
            if (realmGet$longitude != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.longitudeColKey, objKey, realmGet$longitude, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.longitudeColKey, objKey, false);
            }
            String realmGet$country = ((com_example_locationdetail_model_LocationDataRealmProxyInterface) object).realmGet$country();
            if (realmGet$country != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.countryColKey, objKey, realmGet$country, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.countryColKey, objKey, false);
            }
            String realmGet$Locality = ((com_example_locationdetail_model_LocationDataRealmProxyInterface) object).realmGet$Locality();
            if (realmGet$Locality != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.LocalityColKey, objKey, realmGet$Locality, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.LocalityColKey, objKey, false);
            }
            String realmGet$Address = ((com_example_locationdetail_model_LocationDataRealmProxyInterface) object).realmGet$Address();
            if (realmGet$Address != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.AddressColKey, objKey, realmGet$Address, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.AddressColKey, objKey, false);
            }
        }
    }

    public static com.example.locationdetail.model.LocationData createDetachedCopy(com.example.locationdetail.model.LocationData realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.locationdetail.model.LocationData unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.example.locationdetail.model.LocationData();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.locationdetail.model.LocationData) cachedObject.object;
            }
            unmanagedObject = (com.example.locationdetail.model.LocationData) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_example_locationdetail_model_LocationDataRealmProxyInterface unmanagedCopy = (com_example_locationdetail_model_LocationDataRealmProxyInterface) unmanagedObject;
        com_example_locationdetail_model_LocationDataRealmProxyInterface realmSource = (com_example_locationdetail_model_LocationDataRealmProxyInterface) realmObject;
        Realm objectRealm = (Realm) ((RealmObjectProxy) realmObject).realmGet$proxyState().getRealm$realm();
        unmanagedCopy.realmSet$latitude(realmSource.realmGet$latitude());
        unmanagedCopy.realmSet$longitude(realmSource.realmGet$longitude());
        unmanagedCopy.realmSet$country(realmSource.realmGet$country());
        unmanagedCopy.realmSet$Locality(realmSource.realmGet$Locality());
        unmanagedCopy.realmSet$Address(realmSource.realmGet$Address());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("LocationData = proxy[");
        stringBuilder.append("{latitude:");
        stringBuilder.append(realmGet$latitude());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{longitude:");
        stringBuilder.append(realmGet$longitude());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{country:");
        stringBuilder.append(realmGet$country());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Locality:");
        stringBuilder.append(realmGet$Locality());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Address:");
        stringBuilder.append(realmGet$Address());
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long objKey = proxyState.getRow$realm().getObjectKey();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (objKey ^ (objKey >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com_example_locationdetail_model_LocationDataRealmProxy aLocationData = (com_example_locationdetail_model_LocationDataRealmProxy)o;

        BaseRealm realm = proxyState.getRealm$realm();
        BaseRealm otherRealm = aLocationData.proxyState.getRealm$realm();
        String path = realm.getPath();
        String otherPath = otherRealm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;
        if (realm.isFrozen() != otherRealm.isFrozen()) return false;
        if (!realm.sharedRealm.getVersionID().equals(otherRealm.sharedRealm.getVersionID())) {
            return false;
        }

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aLocationData.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getObjectKey() != aLocationData.proxyState.getRow$realm().getObjectKey()) return false;

        return true;
    }
}
