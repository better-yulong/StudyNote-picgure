// File generated by hadoop record compiler. Do not edit.
/**
* Licensed to the Apache Software Foundation (ASF) under one
* or more contributor license agreements.  See the NOTICE file
* distributed with this work for additional information
* regarding copyright ownership.  The ASF licenses this file
* to you under the Apache License, Version 2.0 (the
* "License"); you may not use this file except in compliance
* with the License.  You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package org.apache.zookeeper.proto;

import java.util.*;
import org.apache.jute.*;
public class AuthPacket implements Record {
  private int type;
  private String scheme;
  private byte[] auth;
  public AuthPacket() {
  }
  public AuthPacket(
        int type,
        String scheme,
        byte[] auth) {
    this.type=type;
    this.scheme=scheme;
    this.auth=auth;
  }
  public int getType() {
    return type;
  }
  public void setType(int m_) {
    type=m_;
  }
  public String getScheme() {
    return scheme;
  }
  public void setScheme(String m_) {
    scheme=m_;
  }
  public byte[] getAuth() {
    return auth;
  }
  public void setAuth(byte[] m_) {
    auth=m_;
  }
  public void serialize(OutputArchive a_, String tag) throws java.io.IOException {
    a_.startRecord(this,tag);
    a_.writeInt(type,"type");
    a_.writeString(scheme,"scheme");
    a_.writeBuffer(auth,"auth");
    a_.endRecord(this,tag);
  }
  public void deserialize(InputArchive a_, String tag) throws java.io.IOException {
    a_.startRecord(tag);
    type=a_.readInt("type");
    scheme=a_.readString("scheme");
    auth=a_.readBuffer("auth");
    a_.endRecord(tag);
}
  public String toString() {
    try {
      java.io.ByteArrayOutputStream s =
        new java.io.ByteArrayOutputStream();
      CsvOutputArchive a_ = 
        new CsvOutputArchive(s);
      a_.startRecord(this,"");
    a_.writeInt(type,"type");
    a_.writeString(scheme,"scheme");
    a_.writeBuffer(auth,"auth");
      a_.endRecord(this,"");
      return new String(s.toByteArray(), "UTF-8");
    } catch (Throwable ex) {
      ex.printStackTrace();
    }
    return "ERROR";
  }
  public void write(java.io.DataOutput out) throws java.io.IOException {
    BinaryOutputArchive archive = new BinaryOutputArchive(out);
    serialize(archive, "");
  }
  public void readFields(java.io.DataInput in) throws java.io.IOException {
    BinaryInputArchive archive = new BinaryInputArchive(in);
    deserialize(archive, "");
  }
  public int compareTo (Object peer_) throws ClassCastException {
    if (!(peer_ instanceof AuthPacket)) {
      throw new ClassCastException("Comparing different types of records.");
    }
    AuthPacket peer = (AuthPacket) peer_;
    int ret = 0;
    ret = (type == peer.type)? 0 :((type<peer.type)?-1:1);
    if (ret != 0) return ret;
    ret = scheme.compareTo(peer.scheme);
    if (ret != 0) return ret;
    {
      byte[] my = auth;
      byte[] ur = peer.auth;
      ret = org.apache.jute.Utils.compareBytes(my,0,my.length,ur,0,ur.length);
    }
    if (ret != 0) return ret;
     return ret;
  }
  public boolean equals(Object peer_) {
    if (!(peer_ instanceof AuthPacket)) {
      return false;
    }
    if (peer_ == this) {
      return true;
    }
    AuthPacket peer = (AuthPacket) peer_;
    boolean ret = false;
    ret = (type==peer.type);
    if (!ret) return ret;
    ret = scheme.equals(peer.scheme);
    if (!ret) return ret;
    ret = org.apache.jute.Utils.bufEquals(auth,peer.auth);
    if (!ret) return ret;
     return ret;
  }
  public int hashCode() {
    int result = 17;
    int ret;
    ret = (int)type;
    result = 37*result + ret;
    ret = scheme.hashCode();
    result = 37*result + ret;
    ret = Arrays.toString(auth).hashCode();
    result = 37*result + ret;
    return result;
  }
  public static String signature() {
    return "LAuthPacket(isB)";
  }
}
