String caseCountryCode = _caseCounty != null ? _caseCounty : "";
_judicialDistrict = DomainObject.find(LookupItem.class, "lookupList.name", "COUNTY", "code", caseCountryCode)?.find({it -> it != null})?.description;
_judicialDistrict == null ? "" : _judicialDistrict;




