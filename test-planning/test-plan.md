# Test Plan — NIMC NIN Verification Services (Sample)

## 1. Objective
Validate that NIN verification services return correct, privacy-compliant results
to enterprise verifiers, and that vNIN issuance/expiry behaves exactly as designed.

## 2. In scope
- NIN verification API (basic vs full profile response)
- vNIN issuance, 72-hour expiry, single-use semantics
- Citizen mobile flow: NIN retrieval, OTP, PIN setup
- Consent toggle: Basic ID vs Full ID disclosure
- Negative paths: malformed NIN, expired vNIN, wrong verifier credentials

## 3. Out of scope
- Physical enrolment capture devices (handled at enrolment centres)
- USSD *346# retrieval (telecom-owned channel)

## 4. Environments
- Staging identity API (sandbox NIN records only)
- Android 10/13/14 devices for citizen app
- Postman Newman runner in CI

## 5. Key risk scenarios
| Risk | Severity |
|---|---|
| Full profile returned when citizen consented to Basic | P0 (privacy breach) |
| Expired vNIN still verifies | P0 |
| Malformed 11-digit NIN returns 500 instead of structured error | P1 |
| Verifier sees another citizen's data after session reuse | P0 |

## 6. Entry / Exit
**Entry:** sandbox reset, stubbed SMS OTP.
**Exit:** P0 = 0 open; privacy negative tests pass on every release; regression
automation green.
