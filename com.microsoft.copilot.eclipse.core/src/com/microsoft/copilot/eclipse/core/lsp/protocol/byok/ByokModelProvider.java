// Copyright (c) Microsoft Corporation.
// Licensed under the MIT license.

package com.microsoft.copilot.eclipse.core.lsp.protocol.byok;

/**
 * Enum representing BYOK model providers.
 */
public enum ByokModelProvider {
  AZURE("Azure"),
  OPENAI("OpenAI"),
  GEMINI("Gemini"),
  GROQ("Groq"),
  OPENROUTER("OpenRouter"),
  ANTHROPIC("Anthropic"),
  CUSTOM_OPENAI("Custom OpenAI");


  private final String displayName;

  ByokModelProvider(String displayName) {
    this.displayName = displayName;
  }

  public String getDisplayName() {
    return displayName;
  }

  /**
   * Utility to check if a provider display name corresponds to AZURE.
   * This avoids scattering direct enum displayName comparisons across UI code.
   */
  public static boolean isAzure(String providerDisplayName) {
    return AZURE.getDisplayName().equals(providerDisplayName);
  }

  /**
   * Utility to check whether a provider stores endpoint credentials on each model entry instead of using a single
   * provider-level API key.
   */
  public static boolean usesModelLevelCredentials(String providerDisplayName) {
    return AZURE.getDisplayName().equals(providerDisplayName)
        || CUSTOM_OPENAI.getDisplayName().equals(providerDisplayName);
  }

  @Override
  public String toString() {
    return displayName;
  }
}
