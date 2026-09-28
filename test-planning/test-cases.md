# Sample Test Cases — NIN Verification

| ID | Scenario | Steps | Expected | Priority |
|----|----------|-------|----------|----------|
| TC-01 | Verify valid NIN | POST /verify with valid 11-digit NIN | 200 + names, DOB match core record | P0 |
| TC-02 | Malformed NIN | NIN = "ABC123" | 400 structured error, no stack trace | P1 |
| TC-03 | Basic consent hides DOB | vNIN issued as Basic; verify | Response has names only, DOB field absent | P0 |
| TC-04 | Full consent returns DOB/nationality/sex | vNIN issued as Full; verify | Response includes DOB, nationality, sex | P0 |
| TC-05 | vNIN expired >72h | Verify expired token | 410 Gone with expiry timestamp | P0 |
| TC-06 | vNIN reused after first verify | Use same vNIN twice | Second call rejected (single-use) | P1 |
| TC-07 | Wrong verifier API key | POST with revoked key | 401, no record leaked | P0 |
| TC-08 | Concurrent verification bursts | 50 parallel /verify calls | No cross-customer data bleed | P1 |
