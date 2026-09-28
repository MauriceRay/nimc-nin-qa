# Bug Report (Template)

**Title:** Basic-consent vNIN response leaks DOB to verifier
**ID:** NIMC-2024-0412
**Severity:** P0 / Critical
**Priority:** P0
**Reporter:** Maurice Ray Amande
**Date:** YYYY-MM-DD

## Environment
- API staging: v2.4.1
- Citizen app: Android 14, build 2402
- Verifier: Postman collection v1.3

## Steps to reproduce
1. Citizen issues a vNIN with consent mode = **Basic ID**
2. Verifier calls `POST /vnin/verify` with that vNIN
3. Inspect response body

## Expected
Response contains first name, middle name, last name only.
DOB, nationality, sex fields must be absent.

## Actual
Response includes `dateOfBirth` and `sex` despite Basic consent.

## Evidence
```json
{
  "firstName": "Ada",
    "lastName": "Nwosu",
      "dateOfBirth": "1990-01-15",
        "sex": "F"
        }
        ```

        ## Impact
        Privacy breach: verifiers receive more PII than the citizen consented to.
        Blocks release pending compliance review.

        ## Notes
        Passes on staging v2.3.x — regression introduced in v2.4.0 consent filter.
