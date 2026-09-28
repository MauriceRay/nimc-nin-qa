# NIMC NIN Services — QA Test Assets (SEAMFIX Engagement)

Representative QA portfolio project from the SEAMFIX engagement where I tested
**National Identity Management Commission (NIMC)** services — a regulated,
high-stakes identity platform handling sensitive citizen personal data.

> No confidential NIMC data, credentials, or internal system details are
> included; samples use sandboxed/illustrative values only.

## Context

NIMC issues the **National Identification Number (NIN)** — the 11-digit identity
at the centre of Nigerian KYC: SIM-NIN linkage, banking, government services.
My work at SEAMFIX (Apr 2021 – Jul 2022) centred on validating:

- NIN enrolment/retrieval citizen workflows
- NIN verification API consumed by telecoms and enterprise verifiers
- Virtual NIN (vNIN) issuance and its 72-hour token expiry
- Internal CRM integrations used by NIMC enrolment officers

## Why this is hard testing

- **Regulated identity:** wrong data = failed KYC for banks/telecoms
- **Privacy:** a verification response must expose only what the citizen consents to
- **Cross-system:** citizen app ↔ NIMC core ↔ verifier enterprise APIs
- **High scale:** SMS/USSD channels across all four Nigerian networks

## My scope

- Functional, integration, regression, and UAT testing across browsers/devices
- Postman API suites for NIN/vNIN verification endpoints
- Defect logging (Jira) with repro, expected/actual, environment
- Root-cause analysis and test strategies reviewed by compliance stakeholders

## Layout

```
├── test-planning/        test plan + sample test cases
├── api-testing/          Postman collection for NIN verification endpoints
├── automation/           Appium sample for the citizen mobile flow
└── bug-reports/           representative bug report template
```
