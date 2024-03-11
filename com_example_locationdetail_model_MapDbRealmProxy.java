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
public class com_example_locationdetail_model_MapDbRealmProxy extends com.example.locationdetail.model.MapDb
    implements RealmObjectProxy, com_example_locationdetail_model_MapDbRealmProxyInterface {

    static final class MapDbColumnInfo extends ColumnInfo {
        long idColKey;
        long emailColKey;
        long passwordColKey;
        long locationDataColKey;

        MapDbColumnInfo(OsSchemaInfo schemaInfo) {
            super(4);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("MapDb");
            this.idColKey = addColumnDetails("id", "id", objectSchemaInfo);
            this.emailColKey = addColumnDetails("email", "email", objectSchemaInfo);
            this.passwordColKey = addColumnDetails("password", "password", objectSchemaInfo);
            this.locationDataColKey = addColumnDetails("locationData", "locationData", objectSchemaInfo);
        }

        MapDbColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new MapDbColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final MapDbColumnInfo src = (MapDbColumnInfo) rawSrc;
            final MapDbColumnInfo dst = (MapDbColumnInfo) rawDst;
            dst.idColKey = src.idColKey;
            dst.emailColKey = src.emailColKey;
            dst.passwordColKey = src.passwordColKey;
            dst.locationDataColKey = src.locationDataColKey;
        }
    }

    private static final String NO_ALIAS = "";
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private MapDbColumnInfo columnInfo;
    private ProxyState<com.example.locationdetail.model.MapDb> proxyState;
    private RealmList<com.example.locationdetail.model.LocationData> locationDataRealmList;

    com_example_locationdetail_model_MapDbRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (MapDbColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.example.locationdetail.model.MapDb>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.idColKey);
    }

    @Override
    public void realmSet$id(long value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$email() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.emailColKey);
    }

    @Override
    public void realmSet$email(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.emailColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.emailColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.emailColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.emailColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$password() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.passwordColKey);
    }

    @Override
    public void realmSet$password(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.passwordColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.passwordColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.passwordColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.passwordColKey, value);
    }

    @Override
    public RealmList<com.example.locationdetail.model.LocationData> realmGet$locationData() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (locationDataRealmList != null) {
            return locationDataRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getModelList(columnInfo.locationDataColKey);
            locationDataRealmList = new RealmList<com.example.locationdetail.model.LocationData>(com.example.locationdetail.model.LocationData.class, osList, proxyState.getRealm$realm());
            return locationDataRealmList;
        }
    }

    @Override
    public void realmSet$locationData(RealmList<com.example.locationdetail.model.LocationData> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("locationData")) {
                return;
            }
            // if the list contains unmanaged RealmObjects, convert them to managed.
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.example.locationdetail.model.LocationData> original = value;
                value = new RealmList<com.example.locationdetail.model.LocationData>();
                for (com.example.locationdetail.model.LocationData item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getModelList(columnInfo.locationDataColKey);
        // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
        if (value != null && value.size() == osList.size()) {
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                com.example.locationdetail.model.LocationData linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.setRow(i, ((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getObjectKey());
            }
        } else {
            osList.removeAll();
            if (value == null) {
                return;
            }
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                com.example.locationdetail.model.LocationData linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.addRow(((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getObjectKey());
            }
        }
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(NO_ALIAS, "MapDb", false, 4, 0);
        builder.addPersistedProperty(NO_ALIAS, "id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "email", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "password", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedLinkProperty(NO_ALIAS, "locationData", RealmFieldType.LIST, "LocationData");
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static MapDbColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new MapDbColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "MapDb";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "MapDb";
    }

    @SuppressWarnings("cast")
    public static com.example.locationdetail.model.MapDb createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        com.example.locationdetail.model.MapDb obj = null;
        if (update) {
            Table table = realm.getTable(com.example.locationdetail.model.MapDb.class);
            MapDbColumnInfo columnInfo = (MapDbColumnInfo) realm.getSchema().getColumnInfo(com.example.locationdetail.model.MapDb.class);
            long pkColumnKey = columnInfo.idColKey;
            long objKey = Table.NO_MATCH;
            if (!json.isNull("id")) {
                objKey = table.findFirstLong(pkColumnKey, json.getLong("id"));
            }
            if (objKey != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), realm.getSchema().getColumnInfo(com.example.locationdetail.model.MapDb.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_example_locationdetail_model_MapDbRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("locationData")) {
                excludeFields.add("locationData");
            }
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.com_example_locationdetail_model_MapDbRealmProxy) realm.createObjectInternal(com.example.locationdetail.model.MapDb.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_example_locationdetail_model_MapDbRealmProxy) realm.createObjectInternal(com.example.locationdetail.model.MapDb.class, json.getLong("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final com_example_locationdetail_model_MapDbRealmProxyInterface objProxy = (com_example_locationdetail_model_MapDbRealmProxyInterface) obj;
        if (json.has("email")) {
            if (json.isNull("email")) {
                objProxy.realmSet$email(null);
            } else {
                objProxy.realmSet$email((String) json.getString("email"));
            }
        }
        if (json.has("password")) {
            if (json.isNull("password")) {
                objProxy.realmSet$password(null);
            } else {
                objProxy.realmSet$password((String) json.getString("password"));
            }
        }
        if (json.has("locationData")) {
            if (json.isNull("locationData")) {
                objProxy.realmSet$locationData(null);
            } else {
                objProxy.realmGet$locationData().clear();
                JSONArray array = json.getJSONArray("locationData");
                for (int i = 0; i < array.length(); i++) {
                    com.example.locationdetail.model.LocationData item = com_example_locationdetail_model_LocationDataRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    objProxy.realmGet$locationData().add(item);
                }
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.locationdetail.model.MapDb createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.example.locationdetail.model.MapDb obj = new com.example.locationdetail.model.MapDb();
        final com_example_locationdetail_model_MapDbRealmProxyInterface objProxy = (com_example_locationdetail_model_MapDbRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("email")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$email((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$email(null);
                }
            } else if (name.equals("password")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$password((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$password(null);
                }
            } else if (name.equals("locationData")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$locationData(null);
                } else {
                    objProxy.realmSet$locationData(new RealmList<com.example.locationdetail.model.LocationData>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.example.locationdetail.model.LocationData item = com_example_locationdetail_model_LocationDataRealmProxy.createUsingJsonStream(realm, reader);
                        objProxy.realmGet$locationData().add(item);
                    }
                    reader.endArray();
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
        }
        return realm.copyToRealmOrUpdate(obj);
    }

    static com_example_locationdetail_model_MapDbRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.example.locationdetail.model.MapDb.class), false, Collections.<String>emptyList());
        io.realm.com_example_locationdetail_model_MapDbRealmProxy obj = new io.realm.com_example_locationdetail_model_MapDbRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.example.locationdetail.model.MapDb copyOrUpdate(Realm realm, MapDbColumnInfo columnInfo, com.example.locationdetail.model.MapDb object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.example.locationdetail.model.MapDb) cachedRealmObject;
        }

        com.example.locationdetail.model.MapDb realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.example.locationdetail.model.MapDb.class);
            long pkColumnKey = columnInfo.idColKey;
            long objKey = table.findFirstLong(pkColumnKey, ((com_example_locationdetail_model_MapDbRealmProxyInterface) object).realmGet$id());
            if (objKey == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_example_locationdetail_model_MapDbRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.example.locationdetail.model.MapDb copy(Realm realm, MapDbColumnInfo columnInfo, com.example.locationdetail.model.MapDb newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.locationdetail.model.MapDb) cachedRealmObject;
        }

        com_example_locationdetail_model_MapDbRealmProxyInterface unmanagedSource = (com_example_locationdetail_model_MapDbRealmProxyInterface) newObject;

        Table table = realm.getTable(com.example.locationdetail.model.MapDb.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.idColKey, unmanagedSource.realmGet$id());
        builder.addString(columnInfo.emailColKey, unmanagedSource.realmGet$email());
        builder.addString(columnInfo.passwordColKey, unmanagedSource.realmGet$password());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_example_locationdetail_model_MapDbRealmProxy managedCopy = newProxyInstance(realm, row);
        cache.put(newObject, managedCopy);

        // Finally add all fields that reference other Realm Objects, either directly or through a list
        RealmList<com.example.locationdetail.model.LocationData> locationDataUnmanagedList = unmanagedSource.realmGet$locationData();
        if (locationDataUnmanagedList != null) {
            RealmList<com.example.locationdetail.model.LocationData> locationDataManagedList = managedCopy.realmGet$locationData();
            locationDataManagedList.clear();
            for (int i = 0; i < locationDataUnmanagedList.size(); i++) {
                com.example.locationdetail.model.LocationData locationDataUnmanagedItem = locationDataUnmanagedList.get(i);
                com.example.locationdetail.model.LocationData cachelocationData = (com.example.locationdetail.model.LocationData) cache.get(locationDataUnmanagedItem);
                if (cachelocationData != null) {
                    locationDataManagedList.add(cachelocationData);
                } else {
                    locationDataManagedList.add(com_example_locationdetail_model_LocationDataRealmProxy.copyOrUpdate(realm, (com_example_locationdetail_model_LocationDataRealmProxy.LocationDataColumnInfo) realm.getSchema().getColumnInfo(com.example.locationdetail.model.LocationData.class), locationDataUnmanagedItem, update, cache, flags));
                }
            }
        }

        return managedCopy;
    }

    public static long insert(Realm realm, com.example.locationdetail.model.MapDb object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.example.locationdetail.model.MapDb.class);
        long tableNativePtr = table.getNativePtr();
        MapDbColumnInfo columnInfo = (MapDbColumnInfo) realm.getSchema().getColumnInfo(com.example.locationdetail.model.MapDb.class);
        long pkColumnKey = columnInfo.idColKey;
        long objKey = Table.NO_MATCH;
        Object primaryKeyValue = ((com_example_locationdetail_model_MapDbRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_example_locationdetail_model_MapDbRealmProxyInterface) object).realmGet$id());
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_example_locationdetail_model_MapDbRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, objKey);
        String realmGet$email = ((com_example_locationdetail_model_MapDbRealmProxyInterface) object).realmGet$email();
        if (realmGet$email != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.emailColKey, objKey, realmGet$email, false);
        }
        String realmGet$password = ((com_example_locationdetail_model_MapDbRealmProxyInterface) object).realmGet$password();
        if (realmGet$password != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.passwordColKey, objKey, realmGet$password, false);
        }

        RealmList<com.example.locationdetail.model.LocationData> locationDataList = ((com_example_locationdetail_model_MapDbRealmProxyInterface) object).realmGet$locationData();
        if (locationDataList != null) {
            OsList locationDataOsList = new OsList(table.getUncheckedRow(objKey), columnInfo.locationDataColKey);
            for (com.example.locationdetail.model.LocationData locationDataItem : locationDataList) {
                Long cacheItemIndexlocationData = cache.get(locationDataItem);
                if (cacheItemIndexlocationData == null) {
                    cacheItemIndexlocationData = com_example_locationdetail_model_LocationDataRealmProxy.insert(realm, locationDataItem, cache);
                }
                locationDataOsList.addRow(cacheItemIndexlocationData);
            }
        }
        return objKey;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.locationdetail.model.MapDb.class);
        long tableNativePtr = table.getNativePtr();
        MapDbColumnInfo columnInfo = (MapDbColumnInfo) realm.getSchema().getColumnInfo(com.example.locationdetail.model.MapDb.class);
        long pkColumnKey = columnInfo.idColKey;
        com.example.locationdetail.model.MapDb object = null;
        while (objects.hasNext()) {
            object = (com.example.locationdetail.model.MapDb) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            long objKey = Table.NO_MATCH;
            Object primaryKeyValue = ((com_example_locationdetail_model_MapDbRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_example_locationdetail_model_MapDbRealmProxyInterface) object).realmGet$id());
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_example_locationdetail_model_MapDbRealmProxyInterface) object).realmGet$id());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, objKey);
            String realmGet$email = ((com_example_locationdetail_model_MapDbRealmProxyInterface) object).realmGet$email();
            if (realmGet$email != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.emailColKey, objKey, realmGet$email, false);
            }
            String realmGet$password = ((com_example_locationdetail_model_MapDbRealmProxyInterface) object).realmGet$password();
            if (realmGet$password != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.passwordColKey, objKey, realmGet$password, false);
            }

            RealmList<com.example.locationdetail.model.LocationData> locationDataList = ((com_example_locationdetail_model_MapDbRealmProxyInterface) object).realmGet$locationData();
            if (locationDataList != null) {
                OsList locationDataOsList = new OsList(table.getUncheckedRow(objKey), columnInfo.locationDataColKey);
                for (com.example.locationdetail.model.LocationData locationDataItem : locationDataList) {
                    Long cacheItemIndexlocationData = cache.get(locationDataItem);
                    if (cacheItemIndexlocationData == null) {
                        cacheItemIndexlocationData = com_example_locationdetail_model_LocationDataRealmProxy.insert(realm, locationDataItem, cache);
                    }
                    locationDataOsList.addRow(cacheItemIndexlocationData);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.locationdetail.model.MapDb object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.example.locationdetail.model.MapDb.class);
        long tableNativePtr = table.getNativePtr();
        MapDbColumnInfo columnInfo = (MapDbColumnInfo) realm.getSchema().getColumnInfo(com.example.locationdetail.model.MapDb.class);
        long pkColumnKey = columnInfo.idColKey;
        long objKey = Table.NO_MATCH;
        Object primaryKeyValue = ((com_example_locationdetail_model_MapDbRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_example_locationdetail_model_MapDbRealmProxyInterface) object).realmGet$id());
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_example_locationdetail_model_MapDbRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, objKey);
        String realmGet$email = ((com_example_locationdetail_model_MapDbRealmProxyInterface) object).realmGet$email();
        if (realmGet$email != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.emailColKey, objKey, realmGet$email, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.emailColKey, objKey, false);
        }
        String realmGet$password = ((com_example_locationdetail_model_MapDbRealmProxyInterface) object).realmGet$password();
        if (realmGet$password != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.passwordColKey, objKey, realmGet$password, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.passwordColKey, objKey, false);
        }

        OsList locationDataOsList = new OsList(table.getUncheckedRow(objKey), columnInfo.locationDataColKey);
        RealmList<com.example.locationdetail.model.LocationData> locationDataList = ((com_example_locationdetail_model_MapDbRealmProxyInterface) object).realmGet$locationData();
        if (locationDataList != null && locationDataList.size() == locationDataOsList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objectCount = locationDataList.size();
            for (int i = 0; i < objectCount; i++) {
                com.example.locationdetail.model.LocationData locationDataItem = locationDataList.get(i);
                Long cacheItemIndexlocationData = cache.get(locationDataItem);
                if (cacheItemIndexlocationData == null) {
                    cacheItemIndexlocationData = com_example_locationdetail_model_LocationDataRealmProxy.insertOrUpdate(realm, locationDataItem, cache);
                }
                locationDataOsList.setRow(i, cacheItemIndexlocationData);
            }
        } else {
            locationDataOsList.removeAll();
            if (locationDataList != null) {
                for (com.example.locationdetail.model.LocationData locationDataItem : locationDataList) {
                    Long cacheItemIndexlocationData = cache.get(locationDataItem);
                    if (cacheItemIndexlocationData == null) {
                        cacheItemIndexlocationData = com_example_locationdetail_model_LocationDataRealmProxy.insertOrUpdate(realm, locationDataItem, cache);
                    }
                    locationDataOsList.addRow(cacheItemIndexlocationData);
                }
            }
        }

        return objKey;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.locationdetail.model.MapDb.class);
        long tableNativePtr = table.getNativePtr();
        MapDbColumnInfo columnInfo = (MapDbColumnInfo) realm.getSchema().getColumnInfo(com.example.locationdetail.model.MapDb.class);
        long pkColumnKey = columnInfo.idColKey;
        com.example.locationdetail.model.MapDb object = null;
        while (objects.hasNext()) {
            object = (com.example.locationdetail.model.MapDb) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            long objKey = Table.NO_MATCH;
            Object primaryKeyValue = ((com_example_locationdetail_model_MapDbRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_example_locationdetail_model_MapDbRealmProxyInterface) object).realmGet$id());
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_example_locationdetail_model_MapDbRealmProxyInterface) object).realmGet$id());
            }
            cache.put(object, objKey);
            String realmGet$email = ((com_example_locationdetail_model_MapDbRealmProxyInterface) object).realmGet$email();
            if (realmGet$email != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.emailColKey, objKey, realmGet$email, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.emailColKey, objKey, false);
            }
            String realmGet$password = ((com_example_locationdetail_model_MapDbRealmProxyInterface) object).realmGet$password();
            if (realmGet$password != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.passwordColKey, objKey, realmGet$password, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.passwordColKey, objKey, false);
            }

            OsList locationDataOsList = new OsList(table.getUncheckedRow(objKey), columnInfo.locationDataColKey);
            RealmList<com.example.locationdetail.model.LocationData> locationDataList = ((com_example_locationdetail_model_MapDbRealmProxyInterface) object).realmGet$locationData();
            if (locationDataList != null && locationDataList.size() == locationDataOsList.size()) {
                // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
                int objectCount = locationDataList.size();
                for (int i = 0; i < objectCount; i++) {
                    com.example.locationdetail.model.LocationData locationDataItem = locationDataList.get(i);
                    Long cacheItemIndexlocationData = cache.get(locationDataItem);
                    if (cacheItemIndexlocationData == null) {
                        cacheItemIndexlocationData = com_example_locationdetail_model_LocationDataRealmProxy.insertOrUpdate(realm, locationDataItem, cache);
                    }
                    locationDataOsList.setRow(i, cacheItemIndexlocationData);
                }
            } else {
                locationDataOsList.removeAll();
                if (locationDataList != null) {
                    for (com.example.locationdetail.model.LocationData locationDataItem : locationDataList) {
                        Long cacheItemIndexlocationData = cache.get(locationDataItem);
                        if (cacheItemIndexlocationData == null) {
                            cacheItemIndexlocationData = com_example_locationdetail_model_LocationDataRealmProxy.insertOrUpdate(realm, locationDataItem, cache);
                        }
                        locationDataOsList.addRow(cacheItemIndexlocationData);
                    }
                }
            }

        }
    }

    public static com.example.locationdetail.model.MapDb createDetachedCopy(com.example.locationdetail.model.MapDb realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.locationdetail.model.MapDb unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.example.locationdetail.model.MapDb();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.locationdetail.model.MapDb) cachedObject.object;
            }
            unmanagedObject = (com.example.locationdetail.model.MapDb) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_example_locationdetail_model_MapDbRealmProxyInterface unmanagedCopy = (com_example_locationdetail_model_MapDbRealmProxyInterface) unmanagedObject;
        com_example_locationdetail_model_MapDbRealmProxyInterface realmSource = (com_example_locationdetail_model_MapDbRealmProxyInterface) realmObject;
        Realm objectRealm = (Realm) ((RealmObjectProxy) realmObject).realmGet$proxyState().getRealm$realm();
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$email(realmSource.realmGet$email());
        unmanagedCopy.realmSet$password(realmSource.realmGet$password());

        // Deep copy of locationData
        if (currentDepth == maxDepth) {
            unmanagedCopy.realmSet$locationData(null);
        } else {
            RealmList<com.example.locationdetail.model.LocationData> managedlocationDataList = realmSource.realmGet$locationData();
            RealmList<com.example.locationdetail.model.LocationData> unmanagedlocationDataList = new RealmList<com.example.locationdetail.model.LocationData>();
            unmanagedCopy.realmSet$locationData(unmanagedlocationDataList);
            int nextDepth = currentDepth + 1;
            int size = managedlocationDataList.size();
            for (int i = 0; i < size; i++) {
                com.example.locationdetail.model.LocationData item = com_example_locationdetail_model_LocationDataRealmProxy.createDetachedCopy(managedlocationDataList.get(i), nextDepth, maxDepth, cache);
                unmanagedlocationDataList.add(item);
            }
        }

        return unmanagedObject;
    }

    static com.example.locationdetail.model.MapDb update(Realm realm, MapDbColumnInfo columnInfo, com.example.locationdetail.model.MapDb realmObject, com.example.locationdetail.model.MapDb newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_example_locationdetail_model_MapDbRealmProxyInterface realmObjectTarget = (com_example_locationdetail_model_MapDbRealmProxyInterface) realmObject;
        com_example_locationdetail_model_MapDbRealmProxyInterface realmObjectSource = (com_example_locationdetail_model_MapDbRealmProxyInterface) newObject;
        Table table = realm.getTable(com.example.locationdetail.model.MapDb.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);
        builder.addInteger(columnInfo.idColKey, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.emailColKey, realmObjectSource.realmGet$email());
        builder.addString(columnInfo.passwordColKey, realmObjectSource.realmGet$password());

        RealmList<com.example.locationdetail.model.LocationData> locationDataUnmanagedList = realmObjectSource.realmGet$locationData();
        if (locationDataUnmanagedList != null) {
            RealmList<com.example.locationdetail.model.LocationData> locationDataManagedCopy = new RealmList<com.example.locationdetail.model.LocationData>();
            for (int i = 0; i < locationDataUnmanagedList.size(); i++) {
                com.example.locationdetail.model.LocationData locationDataItem = locationDataUnmanagedList.get(i);
                com.example.locationdetail.model.LocationData cachelocationData = (com.example.locationdetail.model.LocationData) cache.get(locationDataItem);
                if (cachelocationData != null) {
                    locationDataManagedCopy.add(cachelocationData);
                } else {
                    locationDataManagedCopy.add(com_example_locationdetail_model_LocationDataRealmProxy.copyOrUpdate(realm, (com_example_locationdetail_model_LocationDataRealmProxy.LocationDataColumnInfo) realm.getSchema().getColumnInfo(com.example.locationdetail.model.LocationData.class), locationDataItem, true, cache, flags));
                }
            }
            builder.addObjectList(columnInfo.locationDataColKey, locationDataManagedCopy);
        } else {
            builder.addObjectList(columnInfo.locationDataColKey, new RealmList<com.example.locationdetail.model.LocationData>());
        }

        builder.updateExistingTopLevelObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("MapDb = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{email:");
        stringBuilder.append(realmGet$email() != null ? realmGet$email() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{password:");
        stringBuilder.append(realmGet$password() != null ? realmGet$password() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{locationData:");
        stringBuilder.append("RealmList<LocationData>[").append(realmGet$locationData().size()).append("]");
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
        com_example_locationdetail_model_MapDbRealmProxy aMapDb = (com_example_locationdetail_model_MapDbRealmProxy)o;

        BaseRealm realm = proxyState.getRealm$realm();
        BaseRealm otherRealm = aMapDb.proxyState.getRealm$realm();
        String path = realm.getPath();
        String otherPath = otherRealm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;
        if (realm.isFrozen() != otherRealm.isFrozen()) return false;
        if (!realm.sharedRealm.getVersionID().equals(otherRealm.sharedRealm.getVersionID())) {
            return false;
        }

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aMapDb.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getObjectKey() != aMapDb.proxyState.getRow$realm().getObjectKey()) return false;

        return true;
    }
}
