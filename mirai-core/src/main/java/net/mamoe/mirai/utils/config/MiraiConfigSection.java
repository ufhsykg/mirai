package net.mamoe.mirai.utils.config;
import org.jetbrains.annotations.Nullable;

import java.util.IllegalFormatException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class MiraiConfigSection<T> extends MiraiSynchronizedLinkedListMap<String, T> {

    public MiraiConfigSection(){
        super();
    }

    public MiraiConfigSection(LinkedHashMap<String, T> map){
        super(map);
    }

    public int getInt(String key){
        return Integer.valueOf(this.get(key).toString());
    }

    public int getIntOrDefault(String key, int defaultV){
        Object result = this.getOrDefault(key, null);
        try {
            return result == null ? defaultV : Integer.valueOf(result.toString());
        }catch (NumberFormatException ignored){
            return defaultV;
        }
    }

    public int getIntOrThrow(String key, Callable<Throwable> throwableCallable) throws Throwable {
        Object result = this.getOrDefault(key, null);
        if(result == null){
            throw throwableCallable.call();
        }
        try {
            return Integer.valueOf(result.toString());
        }catch (NumberFormatException ignored){
            throw throwableCallable.call();
        }
    }

    public double getDouble(String key){
        return Double.valueOf(this.get(key).toString());
    }

    public double getDoubleOrDefault(String key, double defaultV){
        Object result = this.getOrDefault(key, null);
        try {
            return result==null?defaultV:Double.valueOf(result.toString());
        }catch (NumberFormatException ignored){
            return defaultV;
        }
    }

    public double getDoubleOrThrow(String key, Callable<Throwable> throwableCallable) throws Throwable {
        Object result = this.getOrDefault(key, null);
        if(result == null){
            throw throwableCallable.call();
        }
        try {
            return Double.valueOf(result.toString());
        }catch (NumberFormatException ignored){
            throw throwableCallable.call();
        }
    }

    public float getFloat(String key){
        return Float.valueOf(this.get(key).toString());
    }

    public float getFloatOrDefault(String key, float defaultV){
        Object result = this.getOrDefault(key, null);
        try {
            return result == null ? defaultV : Float.valueOf(result.toString());
        }catch (NumberFormatException ignored){
            return defaultV;
        }
    }

    public float getFloatOrThrow(String key, Callable<Throwable> throwableCallable) throws Throwable {
        Object result = this.getOrDefault(key, null);
        if(result == null){
            throw throwableCallable.call();
        }
        try {
            return Float.valueOf(result.toString());
        }catch (NumberFormatException ignored){
            throw throwableCallable.call();
        }
    }

    public long getLong(String key){
        return Long.valueOf(this.get(key).toString());
    }

    public long getLongOrDefault(String key, long defaultV){
        Object result = this.getOrDefault(key, null);
        try {
            return result == null ? defaultV : Long.valueOf(result.toString());
        }catch (NumberFormatException ignored){
            return defaultV;
        }
    }

    public long getLongOrThrow(String key, Callable<Throwable> throwableCallable) throws Throwable {
        Object result = this.getOrDefault(key, null);
        if(result == null){
            throw throwableCallable.call();
        }
        try {
            return Long.valueOf(result.toString());
        }catch (NumberFormatException ignored){
            throw throwableCallable.call();
        }
    }

    public String getString(String key){
        return String.valueOf(this.get(key));
    }

    public String getStringOrDefault(String key, String defaultV){
        Object result = this.getOrDefault(key, null);
        return result==null?defaultV:result.toString();
    }

    public String getStringOrThrow(String key, Callable<Throwable> throwableCallable) throws Throwable {
        Object result = this.getOrDefault(key, null);
        if(result == null){
            throw throwableCallable.call();
        }
        return result.toString();
    }

    @Nullable
    @Override
    public T put(String key, T value) {
        return super.put(key, value);
    }

    @SuppressWarnings("unchecked")
    public <D> MiraiConfigSection<D> getTypedSection(String key){
        var content = this.get(key);
        if(content instanceof MiraiConfigSection){
            return (MiraiConfigSection<D>) content;
        }
        if(content instanceof Map){
            return new MiraiConfigSection<>(
                (LinkedHashMap<String, D>) content
            );
        }
        return null;
    }

    public MiraiConfigSection<Object> getSection(String key){
        return this.getTypedSection(key);
    }

    @SuppressWarnings("unchecked")
    public <D extends T> D getAsOrDefault(String key, D defaultV){
        return (D)this.getOrDefault(key,defaultV);
    }
}
