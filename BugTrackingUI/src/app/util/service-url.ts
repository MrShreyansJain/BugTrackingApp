import { environment } from '../../environments/environment';

export const prefix = environment.apiUrl;

export const API_SAVE_ISSUE_DETAILS = `${prefix}/issue-track/saveIssue`;
export const API_REMOVE_ISSUE_DETAILS = `${prefix}/issue-track/getIssueList`;
export const API_GET_ISSUE_DETAILS_LIST = `${prefix}/issue-track/getIssueList`;